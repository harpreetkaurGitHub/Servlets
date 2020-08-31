import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

    // Extend HttpServlet class
public class HelloWorld extends HttpServlet {

        private String message;

        public void init() throws ServletException {
            // Do required initialization
            message = "Hello World via Servlet";
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            Map<String,String> map= new HashMap<>();
            map.put("name","Harpreet");
            map.put("field","Engineer");
            map.put("stream","IT");
            map.put("course","B-tech");
            map.put("roll-no","24554667");

            //1 iterate on map and print value in chrome
            //2 response cover all methods (request Dispatcher vs send redirect method)
            //3 request //same
            //4 generic servlet example
            //5 web.xml welcome page
            //6 xhtml example

//            response.sendRedirect();
//            response.addCookie();
//            response.addDateHeader();
//            response.addHeader();
//            response.addIntHeader();
//            response.containsHeader();
//            response.encodeRedirectURL();
//            response.encodeURL();
//            response.getHeader();
//            response.getHeaderNames();
//            response.getStatus();
//            response.getTrailerFields();
//            response.sendError();

            response.setContentType("text/html");
            // Actual logic goes here
            PrintWriter out = response.getWriter();

            Enumeration<String> list = (Enumeration<String>) request.getHeaderNames();
            Iterator<String> ite=list.asIterator();
            while (ite.hasNext()){
               out.println(ite.next());
           }
            out.println("<h1>"+map.get("name")+"</h1>");
            out.println("Hiiiiiiii");
            out.println("<p>"+ new Date().toString() +"</p>");

        }
        public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("I am using Post Method");
            printWriter.print("Hello "+request.getParameter("uname"));
            printWriter.print(" Welcome to login page");
        }
    }
