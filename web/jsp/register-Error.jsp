<%-- 
    Document   : register-Error
    Created on : 02-mar-2016, 18:00:44
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
        <title>Register Error</title>
    </head>
    <body>
        <h1>NickName already used</h1>
        <form action="servletRegisterUser" method="get">
            <button class="btn btn-primary" type="submit">Go to register</button>
        </form>
    </body>
</html>
