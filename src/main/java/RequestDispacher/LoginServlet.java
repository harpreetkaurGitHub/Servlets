package RequestDispacher;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class LoginServlet extends HttpServlet {
    Connection connection;

    public void doPost(HttpServletRequest request, HttpServletResponse response){

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = getConnection("jdbc:mysql://localhost:3306/mydb","harpreet","00000000");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user where email= '"+email+"'and password = '"+password+"'");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeServlet");
            if(resultSet.next()) {
                request.setAttribute("message","welcome into servlet inner-communication  " + email);
                requestDispatcher.forward(request,response);
            }
            else {
                RequestDispatcher requestDispatcher1 = request.getRequestDispatcher("login.html");
                request.setAttribute("message","Please type correct credentials");
                requestDispatcher1.include(request,response);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
