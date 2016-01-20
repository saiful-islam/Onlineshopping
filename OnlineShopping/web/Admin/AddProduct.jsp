
<%@page import="Controller.Helper"%>
<%@page import="Controller.AdminServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        String userName = (String) session.getAttribute("userName");
        String roleName = (String) session.getAttribute("roleName");
        if (userName == null || !roleName.equalsIgnoreCase("admin")) {
            response.sendRedirect("../User/Login.jsp");
        }
        session.setAttribute("actionName", "addproduct");
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
                             <li>
                                <h4 style="color: red; font-weight: bold;">
                                    <%=session.getAttribute("userName")%></h4>
                            </li>
                            <li><a href="../User/Logoff.jsp">sign out</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div>
            <form action="/OnlineShopping/AdminServlet" method="post" class="form-horizontal">
                <fieldset>
                    <legend>Product Details</legend>
                    <div class="form-group">
                        <label for="inputProd" class="col-lg-2 control-label">Product Name</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputProd" name ="inputProductName" placeholder="Product Name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPri" class="col-lg-2 control-label">Price</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="inputPri" name ="inputPrice" placeholder="Price">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <a href="Product.jsp">Back to product list</a>
                            <input type='submit' class="btn btn-primary" name ="Save" value="Save" >
                        </div>
                    </div>

                </fieldset>
            </form>
        </div>
</html>
