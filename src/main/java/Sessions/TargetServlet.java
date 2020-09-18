package Sessions;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TargetServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Cookie[] cookies = request.getCookies();
        for (int i=0 ; i<cookies.length ; i++) {
            System.out.println("Name of cookie "+cookies[i].getName() + "and value ::  " + cookies[i].getValue());
        }

        HttpSession session = request.getSession();
        String userName= (String) session.getAttribute("user");
        response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("<h1>Username is :: "+userName+"</h1>");

    }
}
