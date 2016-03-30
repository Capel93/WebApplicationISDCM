<%-- 
    Document   : index
    Created on : 07-mar-2016, 18:53:04
    Author     : JoanMarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="jsp/logout_confirm.jsp" />
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MyTube</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/logo-nav.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>



    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <img src="css/logo_UPC.JPG" height="59" width="281" >
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/WebApplicationISDCM">Home</a>
                    </li>
                    
                    <li>
                        <a href="servletRegisterUser" method="get">Register</a>
                    </li>
                    <li>
                        <a href="servletListvideo" method="get">Videos</a>
                    </li>
                    <%
                            if(session.getAttribute("user") !=null)
                            { 
                              String user = session.getAttribute("user").toString();
                           %>   <li>    
                                    <a href="#" method="get"><%=user%></a>
                                </li>
                                <li>
                                    <!--<a href="#" onclick="logOut()">Log Out</a>-->
                                    <a href="#" data-href="servletLogOut" data-toggle="modal" data-target="#confirm-logout">Logout</a><br>
                                </li>
                           <% 
                            }else{%>
                                <li>
                                    <a href="servletLoginUser" method="get" >Log In</a>
                                </li>
                            <%}
                        %>
                    
                    
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <div class="container">
        <%
            if(request.getParameter("mylink")!=null)
            { 
              String mylink = request.getParameter("mylink");
           %>    

           <jsp:include page="<%="jsp/"+mylink+".jsp"%>"/>

           <% 
            }else{%>
                <div class="jumbotron">
                
                    <h1>Hello, this is our new page</h1>
                    <p> Go to register, if you have done it, go to login.</p>
                    <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
                </div>
           <%}
        %>
    </div>
    
    <br>
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <script>
    function logOut() {
        var x;
        if (confirm("Are you sure to LogOut?") === true) {
            window.location="servletLogOut";
        } 
    }
    </script>

</html>

