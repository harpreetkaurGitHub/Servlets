package RequestDispacher;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.print(request.getAttribute("message"));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
