
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        request.getSession().setAttribute("userName", null);
        response.sendRedirect("Login.jsp");
    %>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
