
<%@page import="Controller.Helper"%>
<%@page import="Controller.AdminServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        String userName = (String) session.getAttribute("userName");
        String roleName = (String) session.getAttribute("roleName");
        if (userName == null || !roleName.equalsIgnoreCase("admin")) {
            response.sendRedirect("../User/Login.jsp");
        }

    %>
    <body>
        <div>
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="Index.jsp">Online Shopping System</a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                        <ul class="nav navbar-nav">

                            <li class="active"><a href="Product.jsp">Product <span class="sr-only">(current)</span></a></li>

                        </ul>

                        <ul class="nav navbar-nav navbar-right">
                            <li><%=session.getAttribute("userName")%></li>
                            <li><a href="../User/Logoff.jsp">sign out</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <br>
        <br>
        <a href="AddProduct.jsp">Add Product</a>
        <br>
        <div>
            <table class="table table-striped table-hover ">
                <thead>
                    <tr>
                        <th>
                            Product id
                        </th>
                        <th>
                            Product Name
                        </th>
                        <th>
                            Price
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Helper objHelper = new Helper();
                        for (String product : objHelper.GetAllProduct().split("\\|")) { 
                            String productId = product.split(",")[0];
                            String productName = product.split(",")[1];
                            String Price = product.split(",")[2];
                    %>
                    <tr>
                        <td><%=productId%></td>
                        <td><%=productName%></td>
                        <td><%=Price%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
</html>
