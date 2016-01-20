<%@page import="Controller.Helper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        String userName = (String) session.getAttribute("userName");
        if (userName == null) {
            response.sendRedirect("User/Login.jsp");
        }
        String roleName;
        try {
            roleName = (String) session.getAttribute("roleName");
        } catch (Exception ex) {
            roleName = "N/A";
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
                            <li><a href="Admin/Product.jsp">Product <span class="sr-only">(current)</span></a></li>

                        </ul> 
                        
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="OrderListUser.jsp">Order</a>
                            </li>
                            <li>&nbsp;</li>
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
                        try{
                        String [] prods = objHelper.GetAllProduct().split("\\|");
                        for (String product : prods) {
                            String productId = product.split(",")[0];
                            String productName = product.split(",")[1];
                            String Price = product.split(",")[2];
                    %>
                    <tr>
                        <td><%=productId%></td>
                        <td><%=productName%></td>
                        <td><%=Price%></td>
                        <td> <a href="#" onclick="selectProduct(<%=productId%>,'<%=productName%>','<%=Price%>')" class="btn btn-primary btn-xs">Select</a>  </td>
                    </tr>
                    <%}}catch(Exception ex){}%>
                </tbody>
            </table>
        </div>
        <script type="text/javascript">
            function selectProduct(id,name,price)
            {
                var ids;
                if (sessionStorage.getItem("productKey")) {
                    ids = sessionStorage.getItem("productKey");
                    sessionStorage.setItem('productKey', ids + '|' + id+','+name+','+price);
                    ids += '|'+ id+','+name+','+price;
                } else {
                    ids = id+','+name+','+price;
                    sessionStorage.setItem('productKey', id+','+name+','+price);
                }
                alert("You Add "+name);
            }
        </script>
    </body>
</html>
