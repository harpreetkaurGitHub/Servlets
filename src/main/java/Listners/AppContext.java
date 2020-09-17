package Listners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContext implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        String url = servletContext.getInitParameter("DBURL");
        String user = servletContext.getInitParameter("DBUSER");
        String password = servletContext.getInitParameter("DBPWD");


        DBConnectionManager dbManager = new DBConnectionManager(url, user, password);
        servletContext.setAttribute("DBManager", dbManager);
        System.out.println("Database connection initialized for Application.");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute("DBManager");
        dbManager.closeConnection();
        System.out.println("Database connection closed for Application.");

    }

}
