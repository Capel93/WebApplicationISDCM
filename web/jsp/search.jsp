<%-- 
    Document   : search
    Created on : 06-abr-2016, 17:23:44
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
         <br><br><br>
        <form class="form-horizontal" role="form" action="servletSearch" method="post">
            <input type="hidden" name="searchType" value="VideoName" /> 
            <div class="form-group">
                <label class="control-label col-sm-2" for="name">Search by Video Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="videoName" id="name" placeholder="Enter Video Name">
                </div>
            </div>
            <div class="form-group">        
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </div>
        </form>     
        <br><br><br>
        <form class="form-horizontal" role="form" action="servletSearch" method="post">
            <input type="hidden" name="searchType" value="author" /> 
            <div class="form-group">
                <label class="control-label col-sm-2" for="name">Search by Author Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="author" id="name" placeholder="Enter author Name">
                </div>
            </div>
            <div class="form-group">        
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </div>
        </form>     
        <br><br><br>
        <form class="form-horizontal" role="form" action="servletSearch" method="post">
            <input type="hidden" name="searchType" value="creationYear" /> 
            <div class="form-group">
                <label class="control-label col-sm-2" for="name">Search by Creation Year</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="creationYear" id="name" placeholder="Enter Creation Year">
                </div>
            </div>
            <div class="form-group">        
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </div>
        </form>     
    </body>
</html>
