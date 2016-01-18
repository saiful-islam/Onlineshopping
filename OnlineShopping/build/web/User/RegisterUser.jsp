
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register User</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <%
        session.setAttribute("actionName", "register");
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
                        <a class="navbar-brand" href="../Index.jsp">Online Shopping System</a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                        <ul class="nav navbar-nav">
                            <li ><a href="#">Link <span class="sr-only">(current)</span></a></li>
                            <li><a href="#">Link</a></li>

                        </ul>

                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="Login.jsp">Login</a></li>
                            <li class="active"><a  href="RegisterUser.jsp">Register</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <form action="/OnlineShopping/UserServlet" method="post" class="form-horizontal">
            <fieldset>
                <legend>Register User</legend>
                <div class="form-group">
                    <label for="inputUser" class="col-lg-2 control-label">User Name</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="inputUser" name ="inputUserName" placeholder="User Name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPass" class="col-lg-2 control-label">Password</label>
                    <div class="col-lg-10">
                        <input type="password" class="form-control" id="inputPass" name ="inputPassword" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">E-Mail</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="inputEmail" name ="inputEMail" placeholder="E-Mail">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <input type='submit' class="btn btn-primary" name ="Register" value="Register" >
                    </div>
                </div>

            </fieldset>
        </form>

    </body>
</html>
