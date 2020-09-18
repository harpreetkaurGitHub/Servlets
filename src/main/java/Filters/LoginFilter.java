package Filters;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter{

    public void init(FilterConfig config) {

    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chainObj) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = null;
        PrintWriter out = response.getWriter();
        out.print("<html><body><div id='servletResponse' style='text-align: center;'>");

        String pasword = request.getParameter("password");
        System.out.println("Password is : ? " + pasword);

        if (pasword!=null && pasword.equals("admin")){
            chainObj.doFilter(request,response);
        }
        else {
            out.print("<p id='errMsg' style='color: red; font-size: larger;'>Username Or Password Is Invalid. Please Try Again ....!</p>");
            requestDispatcher = request.getRequestDispatcher("indexFilter.jsp");
            requestDispatcher.include(request,response);
        }
        out.write("</div></body></html>");
        out.close();
    }
    public void destroy(){}
}
