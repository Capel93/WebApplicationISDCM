<%-- 
    Document   : register-Result
    Created on : 02-mar-2016, 17:44:53
    Author     : JoanMarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <% String nickname =  request.getParameter("nickname");
	%>
        <title>Hello <%= nickname %></title>
    </head>
    <body>
        <div class="jumbotron" onload="Redirect()">
            <h1>Hello <%= nickname %></h1>
            <p>You will be redirected to login page in 5 sec.</p>
            <form action="servletLoginUser" method="get">
                <button class="btn btn-primary" type="submit">Go to Login</button>
            </form>
        </div>
        <script type="text/javascript">
            
            function Redirect() {
               window.location="servletLoginUser";
            }
            
            setTimeout('Redirect()', 5000);
         
        </script>
    </body>
</html>
