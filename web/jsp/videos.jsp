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
                        i++;
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
                            <td><%=v.getUrl()%></td>
                            <td><%=v.getUploader()%></td>
                        </tr>
        
        <%
                    }       
                }
            }
        %>
        </table>
        <button type="button" class="btn btn-primary" onclick="loadRegister()">Add Video</button>
        <button type="button" class="btn btn-primary" id="save" onclick="save()" style="display:none">Save</button>
        <button type="button" class="btn btn-primary" id="cancel" onclick="cancel()" style="display:none">Cancel</button>
        <script>
            function loadRegister(){
                var table = document.getElementById("videos_table");
                var save = document.getElementById("save");
                var cancel = document.getElementById("cancel");
                save.style.display='inline-block';
                cancel.style.display='inline-block';
                <%
                int lastID = 0;
                int nVideos = 0;
                if(request.getAttribute("listvideos")!=null){
                ArrayList<Video> listvideos = (ArrayList<Video>)request.getAttribute("listvideos");
                lastID = listvideos.get(listvideos.size()-1).getId()+1;
                nVideos = listvideos.size();
                }
                %>
                var rowCount = <%=nVideos%>+1;
                var row = table.insertRow(rowCount);

                row.insertCell(0).innerHTML= '<input type="number" value="<%=lastID%>" id="id" name="id" style="color:LightGray;" readonly>'; //si no es readonly, no es pot llegir el valor al save 
                row.insertCell(1).innerHTML= '<input type="text" value="Title" id="title" name="title" style="color:LightGray">';
                row.insertCell(2).innerHTML= '<input type="text" value="Author" id="author" name="author" style="color:LightGray">';
                row.insertCell(3).innerHTML= '<input type="date" id="creation_date" name="creation_date">';
                row.insertCell(4).innerHTML= '<input type="time" id="duration" name="duration">';
                row.insertCell(5).innerHTML= '<input type="number" value="0" id="views" name="views" style="color:LightGray">';
                row.insertCell(6).innerHTML= '<input type="text" value="Description" id="description" name="description" style="color:LightGray">';
                row.insertCell(7).innerHTML= '<input type="text" value="Format" id="format" name="format" style="color:LightGray">';
                row.insertCell(8).innerHTML= '<input type="url" value="www.url.com" id="url" name="url" style="color:LightGray">';
                row.insertCell(9).innerHTML= '<input type="text" value="<%=session.getAttribute("user").toString()%>" id="uploader" name="uploader" style="color:LightGray">';
                
            }
            function reset(input){
                var i = document.getElementById(input);
                i.value="";
                i.style="color:Black";
            }
            function cancel(){
                var table = document.getElementById("videos_table");
                var save = document.getElementById("save");
                var cancel = document.getElementById("cancel");
                var rowCount = table.rows.length;
                table.deleteRow(rowCount-1);
                save.style.display='none';
                cancel.style.display='none';
            }
            function save(){
                
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "servletListvideo");

               
                var id = document.getElementById("id");
                var title = document.getElementById("title");
                var author = document.getElementById("author");
                var creation_date = document.getElementById("creation_date");
                var duration = document.getElementById("duration");
                var views = document.getElementById("views");
                var description = document.getElementById("description");
                var format = document.getElementById("format");
                var url = document.getElementById("url");
                var uploader = document.getElementById("uploader");



                form.appendChild(id);
                form.appendChild(title);
                form.appendChild(author);
                form.appendChild(creation_date);
                form.appendChild(duration);
                form.appendChild(views);
                form.appendChild(description);
                form.appendChild(format);
                form.appendChild(url);
                form.appendChild(uploader);

                document.body.appendChild(form);
                form.submit();
                
            }
        </script>
    </body>
    
</html>
