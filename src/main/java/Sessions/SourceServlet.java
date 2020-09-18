package Sessions;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SourceServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Cookie[] cookies = request.getCookies();
        for (int i=0 ; i<cookies.length ; i++) {
            System.out.println("Name of cookie "+cookies[i].getName() + " and value ::  " + cookies[i].getValue());
        }
        response.addCookie(new Cookie("securityCode","123456"));

        String userName = request.getParameter("userName");
        HttpSession session = request.getSession();
        session.setAttribute("user",userName);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String url = "targetServlet?sessionId=0000";
        out.print("<a href = 'targetServlet'>Click here to get the username </a><br>");
        out.print("<a href ='" +url+"'>Click here to get the username by url Re-writting just hover on the url </a>");
        }
    }
