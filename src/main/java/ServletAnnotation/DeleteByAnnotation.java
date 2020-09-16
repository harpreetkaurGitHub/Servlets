package ServletAnnotation;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.DriverManager.getConnection;

@WebServlet(urlPatterns = "/deleteServlet",initParams = {@WebInitParam(name = "conn",value = "jdbc:mysql://localhost:3306/mydb"),
        @WebInitParam(name = "dbUser",value = "harpreet"),@WebInitParam(name = "dbPass",value = "00000000")})
public class DeleteByAnnotation extends HttpServlet{
    Connection connection;
    public void init(ServletConfig config){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = getConnection(config.getInitParameter("conn"),config.getInitParameter("dbUser"),config.getInitParameter("dbPass"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("delete from user where email = '"+email+"'");
            PrintWriter out = response.getWriter();
            if (result>0) {
                out.print("<H1> USER DELETED </H1>");
            }
            else {
                out.print("<H1> ERROR !! PLEASE CORRECT YOUR EMAIL </H1>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void destroyed(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

