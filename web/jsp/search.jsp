<%-- 
    Document   : search
    Created on : 06-abr-2016, 17:23:44
    Author     : JoanMarc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Video"%>
<jsp:include page="delete_confirm.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <div class="container-fluid">
                 
        <form class="navbar-form navbar-left" role="search" style="inline" action="servletSearch" method="post">
            
            
            <input type="hidden" id="buttonvalue"/>
            <div class="form-group">
                
                <div class="btn-group" data-toggle="buttons">
                    <label class="btn btn-primary active" onclick="textType()">
                        <input type="radio" name="options" id="title" value="title" autocomplete="off"  checked> Title
                    </label>
                    <label class="btn btn-primary" onclick="textType()" >
                        <input type="radio" name="options" id="author" value="author" autocomplete="off" "> Author
                    </label>
                    <label class="btn btn-primary" onclick="numberType()">
                        <input type="radio" name="options" id="year"  value="year" autocomplete="off" > Year
                    </label>
                </div>
                
                <input type="text" class="form-control" placeholder="Search" name="searchField" id="searchField" size="100" >
                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
            </div>
        </form>
        </div>
        
        <script>
            
            function numberType(){
                var input = document.getElementById("searchField");
                input.type = "number";
            }
            function textType(){
                var input = document.getElementById("searchField");
                input.type = "text";
            }
        </script>
            
        
        
        
        
        <div>
        <% if(request.getAttribute("searchType")!=null){%>
            <h2>List of Videos in the Database filtered by <%=request.getAttribute("searchType")%> </h2>
        <%}else{%>
        <h2>List of Videos in the Database </h2>
        <%}%>
        <table class="table table-hover" id="videos_table" onload="loadTable()">
            <tr>
                <th>#</th>
                <th>Title</th>		
                <th>Author</th>
                <th>Creation Date</th>
                <th>Duration</th>
                <th>Views</th>
                <th>Description</th>
                <th>Format</th>
                <th>Url</th>
                <th>Uploader</th>
                <th></th>
            </tr>
            <%
            if(request.getAttribute("listvideos")!=null)
            { 
              
              ArrayList<Video> listvideos = (ArrayList<Video>)request.getAttribute("listvideos");
              
              if(listvideos.size()==0){%>
                <tr>
                    <td>-</td>
                    <td>-</td>		
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
              
              <%}else{

                    for(Video v: listvideos){
                    %>  
                        <tr>
                            <td><%=v.getId()%></td>
                            <td><%=v.getTitle()%></td>		
                            <td><%=v.getAuthor()%></td>
                            <td><%=v.getCreation_date()%></td>
                            <td><%=v.getDuration()%></td>
                            <td><%=v.getViews()%></td>
                            <td><%=v.getDescription()%></td>
                            <td><%=v.getFormat()%></td>
                            <td><a href="http://<%=v.getUrl()%>"><%=v.getUrl()%></a></td>
                            <td><%=v.getUploader()%></td>
                            
                            <td>
                                <button class="btn btn-xs btn-danger" data-href="JavaScript:remove(<%=v.getId()%>)" data-toggle="modal" data-target="#confirm-delete">
                                <i class="glyphicon glyphicon-trash"></i> Delete
                                </button>
                            </td>
                        </tr>
        
        <%
                    }       
                }
            }
        %>
        </table>
           
        
            
        </div>
        </div>
        <script>

            function remove(delete_id){
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "servletListvideo");
                var action = document.createElement("input");
                action.value="delete";
                action.name="action";
                
                var element = document.createElement("input");
                element.value=delete_id;
                element.name="delete_id";
                
                form.appendChild(action);
                form.appendChild(element);
                document.body.appendChild(form);
                form.submit();
            }
            
            
        </script>
    </body>
</html>


