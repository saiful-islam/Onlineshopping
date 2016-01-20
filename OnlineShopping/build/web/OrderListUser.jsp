<%@page import="Controller.Helper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="shoppingApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        session.setAttribute("actionName", "userOrder");
        String userName = (String) session.getAttribute("userName");
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
                            <li><a href="Admin/Product.jsp">Product <span class="sr-only">(current)</span></a></li>

                        </ul> 

                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="shoppingcart.jsp">Shopping Cart</a>
                            </li>
                            <li>&nbsp;</li>
                            <li>
                                <h4 style="color: red; font-weight: bold;">
                                    <%=session.getAttribute("userName")%></h4>
                            </li>
                            <li><a href="User/Logoff.jsp">sign out</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <h1>Order List</h1>
        <div>
            <table class="table table-striped table-hover ">
                <thead>
                    <tr>
                        <th>
                            Id
                        </th>
                        <th>
                            Price
                        </th>
                        <th>
                            Delivery Address
                        </th>
                        <th>
                            Date
                        </th>
                        <th>
                            Phone
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Helper objHelper = new Helper();
                        try {
                            String[] carts = objHelper.GetShoppingCartByUser(userName).split("\\|");
                            for (String cart : carts) {
                                String cartId = cart.split(",")[0];
                                String price = cart.split(",")[1];
                                String deliveryAddress = cart.split(",")[2];
                                String date = cart.split(",")[3];
                                String phone = cart.split(",")[4];
                    %>
                    <tr>
                        <td><%=cartId%></td>
                        <td><%=price%></td>
                        <td><%=deliveryAddress%></td>
                        <td><%=date%></td>
                        <td><%=phone%></td>

                    </tr>
                    <%}
                        } catch (Exception ex) {
                        }%>
                </tbody>
            </table>
        </div>

    </body>
</html>
