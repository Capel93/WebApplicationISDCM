<%-- 
    Document   : register
    Created on : 02-mar-2016, 17:45:05
    Author     : JoanMarc
--%>

<%@page import="javax.validation.Validation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome to MVC project</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="servletRegisterUser"  method="post">
            First name:<br>
            <input type="text" name="name" ><br>
            Last name:<br>
            <input type="text" name="lastName"><br><br>
            Email:<br>
            <input type="text" name="mail"><br><br>
            User Name:<br>
            <input type="text" name="nickname"><br><br>
            Password:<br>
            <input type="text" name="password"><br><br>
            Repeat Password:<br>
            <input type="text" name="password2"><br><br>
            
            <input type="submit" value="Create new user">
        </form> 
    </body>
</html>
