<%-- 
    Document   : viewVideo
    Created on : 07/05/2016, 22:28:45
    Author     : Josep D. Capdevila
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Video"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if (request.getAttribute("video") != null) {%>
            <%Video v = (Video) request.getAttribute("video");%>

            <%if (request.getAttribute("location") == "youtube") {%>
                <iframe width="854" height="480"
                        src="<%=v.getUrl()%>?autoplay=1" allowfullscreen> 
                </iframe>
            <%} else if (request.getAttribute("location") == "local") {%>
                <video width="854" height="480" id="video" controls autoplay>
                    <source src="<%=v.getUrl()%>" type="video/mp4">
                </video>
            <%}%>


            <h1><%=v.getTitle()%></h1>
            <h4><%=v.getViews()%> views</h4>
            <h4>Uploaded by: <%=v.getUploader()%></h4>
            <h4>Created by: <%=v.getAuthor()%> - <%=v.getCreation_date()%> </h4>
            <h4><%=v.getDescription()%></h4> 
         
        <%}%>
         
        <script>
            
            var video = document.getElementById("video")[0];
            var first = true;
            if(video.onplay()&&first){
                
            }
             
        </script>
       
           <!--videos/Triple.9.2016.720p.WEBRip.x264.AAC-ETRG.mp4" type="video/mp4-->
        
    </body>
</html>
