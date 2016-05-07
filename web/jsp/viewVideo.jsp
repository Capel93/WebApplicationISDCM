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
         <% if(request.getAttribute("video")!=null){%>
            <%Video v = (Video)request.getAttribute("video");%>
            
            <%if (request.getAttribute("location")== "youtube"){%>
                <iframe width="1280" height="720"
                src="<%=v.getUrl()%>">
                </iframe>
             <%} else if (request.getAttribute("location")== "local"){%>
                <video width="1280" height="720" controls>
                    <source src="<%=v.getUrl()%>" type="video/mp4">
                </video>
             <%}%>
             
             <%=v.getTitle()%> 
             <%=v.getAuthor()%> 
            
            <%=v.getUploader()%>
            
            <%=v.getViews()%>
         
         <%}%>
         
       
           <!--videos/Triple.9.2016.720p.WEBRip.x264.AAC-ETRG.mp4" type="video/mp4-->
        
    </body>
</html>
