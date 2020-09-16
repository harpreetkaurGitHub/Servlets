import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class Product extends HttpServlet {

    Connection connection;
    PreparedStatement preparedStatement ;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = getConnection("jdbc:mysql://localhost:3306/mydb","harpreet","00000000");
            preparedStatement = connection.prepareStatement("insert into product values(?,?,?,?)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));

        try {
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,desc);
            preparedStatement.setInt(4,price);

            int result = preparedStatement.executeUpdate();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("<b>" + result + " products created" + "</b>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public void destroy() {
        try {
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
