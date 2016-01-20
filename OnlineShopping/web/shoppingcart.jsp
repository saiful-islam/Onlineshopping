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
        session.setAttribute("actionName", "shoppingcart");
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
        <h1>Product List</h1>
        <div id="divList">
        </div>
        <br>
        <form action="UserServlet" method="post" class="form-horizontal">
            <fieldset>
                <legend>Customer Info</legend>
                <div class="form-group">
                    <label for="inputUser" class="col-lg-2 control-label">Delivery Address</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" id="inputUser" name ="inputDeliveryAddress" placeholder="Delivery Address">
                        <input type="text" style="display: none;" class="form-control" id="inputProduct" name ="inputProductIds" placeholder="User Name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPass" class="col-lg-2 control-label">Date</label>
                    <div class="col-lg-4">
                        <input type="date" class="form-control" id="inputPass" name ="inputDate" placeholder="Date">
                    </div>
                </div>
                 <div class="form-group">
                    <label for="inputPass2" class="col-lg-2 control-label">Phone</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" id="inputPass2" name ="inputPhone" placeholder="Phone">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <input type='submit' class="btn btn-primary" name ="Confirm" value="Confirm" >
                    </div>
                </div>

            </fieldset>
        </form>
        <script type="text/javascript">
            if(!sessionStorage.getItem("productKey"))
            {
                window.location="Index.jsp";
            }
            var prodList = sessionStorage.getItem("productKey").toString().split("|");
            var innerHtmlList = "<table class='table table-striped table-hover'><thead><tr><th>Product id</th>";
            innerHtmlList += "<th>Product Name</th><th>Price</th></tr></thead><tbody>";
            var productIds="";
            var total=0.0;
            for (var prod in prodList)
            {
                var temp = prodList[prod].split(",");
                productIds +=","+temp[0];
                total += parseFloat(temp[2]);
                innerHtmlList += "<tr><td>" + temp[0] + "</td><td>" + temp[1] + "</td><td>" + temp[2] + "</td></tr>";
                console.log(temp);
            }
            innerHtmlList += "<tr><td></td><th>Total:</th><th>"+total+"</th></tr></tbody></table>";
            document.getElementById("divList").innerHTML = innerHtmlList;
            document.getElementById("inputProduct").value=productIds.substring(1);
        </script>
    </body>
</html>
