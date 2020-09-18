<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: harpreet
  Date: 18/09/20
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%

    int result = (Integer) request.getAttribute("result");
    System.out.println(result);
    PrintWriter writer = response.getWriter();
    writer.print("<br> Average number is  " +result+"</br>");




%>
</body>
</html>
