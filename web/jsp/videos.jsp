<%-- 
    Document   : videos
    Created on : 16-mar-2016, 16:34:17
    Author     : JoanMarc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Video"%>
<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>List of Videos in Database</h2>
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
            </tr>
            <%
            if(request.getAttribute("listvideos")!=null)
            { 
              ArrayList<Video> listvideos = (ArrayList<Video>)request.getAttribute("listvideos");
              int i=0;
              for(Video v: listvideos){
                  i++;
        %>  
            <tr>
                <td><%=i%></td>
                <td><%=v.getTitle()%></td>		
                <td><%=v.getAuthor()%></td>
                <td><%=v.getCreation_date()%></td>
                <td><%=v.getDuration()%></td>
                <td><%=v.getViews()%></td>
                <td><%=v.getDescription()%></td>
                <td><%=v.getFormat()%></td>
                <td><%=v.getUrl()%></td>
                <td><%=v.getUploader()%></td>
            </tr>
        
        <%
                          
                }
            }
        %>
        </table>
        <button type="button" class="btn btn-primary" onclick="loadRegister()">Add Video</button>
        <button type="button" class="btn btn-primary" onclick="save()">Save</button>
        <script>
            function loadRegister(){
                var table = document.getElementById("videos_table");
                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);

                row.insertCell(0).innerHTML= '<input type="number" id="id">';
                row.insertCell(1).innerHTML= '<input type="text" value="Title" id="title">';
                row.insertCell(2).innerHTML= '<input type="text" value="Author" id="author">';
                row.insertCell(3).innerHTML= '<input type="date" id="creation_date">';
                row.insertCell(4).innerHTML= '<input type="datetime-local" id="duration">';
                row.insertCell(5).innerHTML= '<input type="number" value="0" id="views">';
                row.insertCell(6).innerHTML= '<input type="text" value="Description" id="description">';
                row.insertCell(7).innerHTML= '<input type="text" value="Format" id="format">';
                row.insertCell(8).innerHTML= '<input type="url" value="Url" id="url">';
                row.insertCell(9).innerHTML= '<input type="text" value="Uploader" id="uploader">';
                
            }
            function save(){
                var table = document.getElementById("videos_table");
                var rowCount = table.rows.length-1;
                
            }
        </script>
    </body>
    
</html>
