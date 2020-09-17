package Sessions;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class TargetServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String userName= (String) session.getAttribute("user");
        response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("<h1>Username is :: "+userName+"</h1>");

    }
}
