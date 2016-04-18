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
    <body onload="init()">
        
        
        
                 
        <form class="navbar-form navbar-left" role="search" style="inline" onSubmit="sendForm()">
            
            
            <input type="hidden" id="buttonvalue"/>
            <div class="form-group">
                
                <div class="btn-group" data-toggle="buttons">
                    <label class="btn btn-primary active" onClick="selectButtonTitle()">
                        <input type="radio" name="options" id="title" value="title" autocomplete="off"  checked> Title
                    </label>
                    <label class="btn btn-primary" onClick="selectButtonAuthor()">
                        <input type="radio" name="options" id="author" value="author" autocomplete="off"> Author
                    </label>
                    <label class="btn btn-primary" onClick="selectButtonYear()">
                        <input type="radio" name="options" id="year"  value="year" autocomplete="off" > Year
                    </label>
                </div>
                
                <input type="text" class="form-control" placeholder="Search" id="searchField" size="100">
                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
            </div>
        </form>
    </body>
</html>


<script>
    var searchType;
    function selectButtonTitle(){
        searchType="title";
    }
    function selectButtonAuthor(){
       searchType="author";
    }
    function selectButtonYear(){
        searchType="year";
    }
    
    function sendForm(){
        
        var form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", "servletSearch");
        
        var searchAction = document.createElement("input");
        searchAction.value=searchType;
        searchAction.name="searchType";
                    
        var searchField = document.getElementById("searchField");
       
        form.appendChild(searchField);
        form.appendChild(searchAction);
                    
        document.body.appendChild(form);
        
        alert(searchAction.value);
        form.submit();
        
    }
    
    function init(){
        searchType = "title";
    }
</script>