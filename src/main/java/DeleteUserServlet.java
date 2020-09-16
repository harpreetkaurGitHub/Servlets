import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.DriverManager.getConnection;

public class DeleteUserServlet extends HttpServlet{
        Connection connection;
        public void init(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String username = "harpreet";
                String pass = "00000000";
                connection = getConnection("jdbc:mysql://localhost:3306/mydb",username,pass);
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
