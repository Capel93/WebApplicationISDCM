<%-- 
    Document   : mainPage
    Created on : 01-mar-2016, 20:25:26
    Author     : JoanMarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String nickname =  request.getParameter("nickname");
	%>
        <h1>Hello <%= nickname %></h1>
    </body>
</html>
