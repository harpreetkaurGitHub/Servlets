
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class CreateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
//        printWriter.println("<h1>Servlet</h1>");
//        printWriter.println("<h2>Servlet</h2>");
//        printWriter.println("<h3>Servlet</h3>");
//        printWriter.println("<h4>Servlet</h4>");
//        printWriter.println("<h5>Servlet</h5>");
//        printWriter.println("<h6>Servlet</h6>");

//        response.sendError(404,"Page not found");
        String ss =request.getHeader("name");
        printWriter.println(ss);

        response.addHeader("name","new value");
        response.setStatus(400);

       String name = request.getParameter("username");
       String age = request.getParameter("password");

       printWriter.println("NAME :: " + name);
       printWriter.println("AGE :: " + age);

       printWriter.println("Get head information");

        Enumeration en = request.getHeaderNames();
        while (en.hasMoreElements()) {
            String hname = (String)en.nextElement();
            String hvalue = request.getHeader(hname);
            printWriter.println(hname + " " + hvalue);
            printWriter.println("I am using getmethod");
        }
        System.out.println("getContexPath() -- " + request.getContextPath());
        System.out.println("getPath() -- " + request.getMethod());
        System.out.println("getPathInfo() -- " + request.getPathInfo());
        System.out.println("getQUERYString() -- " + request.getQueryString());
        System.out.println("getRemoteUser() -- " + request.getRemoteUser());
        System.out.println("getRequestedSessionID() -- " + request.getRequestedSessionId());
        System.out.println("getRequestURI() -- " + request.getRequestURI());
        System.out.println("getServletPath() -- " + request.getServletPath());

        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{

        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String uname = request.getParameter("uname");
        String uage = request.getParameter("uage");

        printWriter.println(uname);
        printWriter.println(uage);
        if (uname.equals("Harpreet")&& uage.equals("21")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("HelloWorld");
            requestDispatcher.forward(request,response);

        }
        else {
            printWriter.println("usename password is incorrect");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("hello.html");
            requestDispatcher.include(request,response);
        }


    }


}

// todo
//  1. welcome-list with code
//  2. session in servlets
//  3. getRequestSessionId()
//  4. cookie
