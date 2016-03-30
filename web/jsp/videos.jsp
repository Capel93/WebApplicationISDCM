<%--
    Document   : videos
    Created on : 16-mar-2016, 16:34:17
    Author     : JoanMarc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Video"%>
<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<jsp:include page="delete_confirm.jsp" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h2>List of Videos in the Database</h2>
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
           
        <button type="button" class="btn btn-primary" id="addVideo" onclick="loadRegister()">Add Video</button>
        <button type="button" class="btn btn-primary" id="save" onclick="save()" style="display:none">Save</button>
        <button type="button" class="btn btn-primary" id="cancel" onclick="cancel()" style="display:none">Cancel</button>
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
            
            function loadRegister(){
                var table = document.getElementById("videos_table");
                var addVideo = document.getElementById("addVideo");
                var save = document.getElementById("save");
                var cancel = document.getElementById("cancel");
                addVideo.style.display='none';
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
                var hoy = new Date(),
                    d = hoy.getDate(),
                    m = hoy.getMonth()+1, 
                    y = hoy.getFullYear(),
                    data;

                if(d < 10){
                    d = "0"+d;
                };
                if(m < 10){
                    m = "0"+m;
                };

                data = y+"-"+m+"-"+d;
                
                row.insertCell(0).innerHTML= '<input type="number" value="<%=lastID%>" id="id" name="id" style="color:LightGray;" readonly>'; //si no es readonly, no es pot llegir el valor al save 
                row.insertCell(1).innerHTML= '<input type="text" value="Title" id="title" name="title" style="color:LightGray">';
                row.insertCell(2).innerHTML= '<input type="text" value="Author" id="author" name="author" style="color:LightGray">';
                row.insertCell(3).innerHTML= '<input type="date" id="creation_date" name="creation_date">';
                row.insertCell(4).innerHTML= '<input type="time" id="duration" name="duration" step="1" >';
                row.insertCell(5).innerHTML= '<input type="number" value="0" id="views" name="views" style="color:LightGray">';
                row.insertCell(6).innerHTML= '<input type="text" value="Description" id="description" name="description" style="color:LightGray">';
                row.insertCell(7).innerHTML= '<input type="text" value="Format" id="format" name="format" style="color:LightGray">';
                row.insertCell(8).innerHTML= '<input type="url" value="www.url.com" id="url" name="url" style="color:LightGray">';
                row.insertCell(9).innerHTML= '<input type="text" value="<%=session.getAttribute("user").toString()%>" id="uploader" name="uploader" style="color:LightGray">';
                
                var date_input = document.getElementById("creation_date");
                date_input.value = data;
            }
            function reset(input){
                var i = document.getElementById(input);
                i.value="";
                i.style="color:Black";
            }
            function cancel(){
                var table = document.getElementById("videos_table");
                var addVideo = document.getElementById("addVideo");
                var save = document.getElementById("save");
                var cancel = document.getElementById("cancel");
                var rowCount = table.rows.length;
                table.deleteRow(rowCount-1);
                addVideo.style.display='inline-block';
                save.style.display='none';
                cancel.style.display='none';
            }
            function save(){
                
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "servletListvideo");
                var action = document.createElement("input");
                action.value="post";
                action.name="action";
                

               
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


                form.appendChild(action);
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
