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

public class CreateByAnnotation extends HttpServlet {

    @WebServlet(urlPatterns = "/addServlet",initParams = {@WebInitParam(name = "conn",value = "jdbc:mysql://localhost:3306/mydb"),
            @WebInitParam(name = "dbUser",value = "harpreet"),@WebInitParam(name = "dbPass",value = "00000000")})
    public class CreateUserServlet extends HttpServlet {
        Connection connection;
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

        public void init(ServletConfig config){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = getConnection(config.getInitParameter("conn"),config.getInitParameter("dbUser"),config.getInitParameter("dbPass"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            try {
                Statement statement = connection.createStatement();
                int result = statement.executeUpdate("insert into user values('"+firstname+"','"+lastname+"','"+email+"','"+password+"')");
                PrintWriter out = response.getWriter();
                if (result>0) {
                    out.print("<H1> USER CREATED </H1>");
                }
                else {
                    out.print("<H1> ERROR CREATING THE USER </H1>");
                }
            } catch (Exception e) {
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

}
