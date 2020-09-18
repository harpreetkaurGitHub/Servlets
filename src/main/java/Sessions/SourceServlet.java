package Sessions;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SourceServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        HttpSession session = request.getSession();
        session.setAttribute("user",userName);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<a href = 'targetServlet'>Click here to get the username </a>");
        }
    }
