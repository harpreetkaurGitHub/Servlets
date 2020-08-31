import javax.security.sasl.SaslException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HeadInfo extends HttpServlet{
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, SaslException {
       response.setContentType("text/html");
       PrintWriter printWriter = response.getWriter();
       printWriter.println("hi am anchor tag link");
   }
}
