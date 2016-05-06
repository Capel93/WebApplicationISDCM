<%-- 
    Document   : streamingVideos
    Created on : 03-may-2016, 17:45:18
    Author     : JoanMarc
--%>

<%@page import="Model.Video"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.12.3.min.js"></script>
        <script type="text/javascript" src="js/jquery.jplayer.min.js"></script>
        <link type="text/css" href="skin/pink_flag/jplayer.pink.flag.scss" rel="stylesheet" />
        <script type="text/javascript">
            $(document).ready(function(){
              $("#jquery_jplayer_1").jPlayer({
                ready: function () {
                  $(this).jPlayer("setMedia", {
                    title: "Big Buck Bunny Trailer",
                    m4v: "http://www.jplayer.org/video/m4v/Big_Buck_Bunny_Trailer.m4v",
                    ogv: "http://www.jplayer.org/video/ogv/Big_Buck_Bunny_Trailer.ogv",
                    poster: "http://www.jplayer.org/video/poster/Big_Buck_Bunny_Trailer_480x270.png"
                  });
                },
                cssSelectorAncestor: "#jp_container_1",
                swfPath: "/js",
                supplied: "m4v, ogv",
                useStateClassSkin: true,
                autoBlur: false,
                smoothPlayBar: true,
                keyEnabled: true,
                remainingDuration: true,
                toggleDuration: true
              });
            });
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            if(request.getAttribute("video")!=null)
            { 
              
              Video v = (Video)request.getAttribute("video");
              
            %>
        <div class="container">
            <div class="jumbotron">
                <h2>Detail of video</h2>
                <ul class="list-group">
                    <li class="list-group-item">ID: <%=v.getId()%></li>
                    <li class="list-group-item">Title: <%=v.getTitle()%></li>	
                    <li class="list-group-item">Author: <%=v.getAuthor()%></li>
                    <li class="list-group-item">Creation Date: <%=v.getCreation_date()%></li>
                    <li class="list-group-item">Duration: <%=v.getDuration()%></li>
                    <li class="list-group-item">Views: <%=v.getViews()%></li>
                    <li class="list-group-item">Description: <%=v.getDescription()%></li>
                    <li class="list-group-item">Format: <%=v.getFormat()%></li>
                    <li class="list-group-item">URL: <a href="http://<%=v.getUrl()%>"><%=v.getUrl()%></a></li>
                    <li class="list-group-item">Uploader: <%=v.getUploader()%></li>
                </ul>
                
                
            </div>
        </div>
        
                    
        <%}%>
        
        
        <div id="jp_container_1" class="jp-video " role="application" aria-label="media player">
            <div class="jp-type-single">
              <div id="jquery_jplayer_1" class="jp-jplayer"></div>
              <div class="jp-gui">
                <div class="jp-video-play">
                  <button class="jp-video-play-icon" role="button" tabindex="0">play</button>
                </div>
                <div class="jp-interface">
                  <div class="jp-progress">
                    <div class="jp-seek-bar">
                      <div class="jp-play-bar"></div>
                    </div>
                  </div>
                  <div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>
                  <div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>
                  <div class="jp-details">
                    <div class="jp-title" aria-label="title">&nbsp;</div>
                  </div>
                  <div class="jp-controls-holder">
                    <div class="jp-volume-controls">
                      <button class="jp-mute" role="button" tabindex="0">mute</button>
                      <button class="jp-volume-max" role="button" tabindex="0">max volume</button>
                      <div class="jp-volume-bar">
                        <div class="jp-volume-bar-value"></div>
                      </div>
                    </div>
                    <div class="jp-controls">
                      <button class="jp-play" role="button" tabindex="0">play</button>
                      <button class="jp-stop" role="button" tabindex="0">stop</button>
                    </div>
                    <div class="jp-toggles">
                      <button class="jp-repeat" role="button" tabindex="0">repeat</button>
                      <button class="jp-full-screen" role="button" tabindex="0">full screen</button>
                    </div>
                  </div>
                </div>
              </div>
              <div class="jp-no-solution">
                <span>Update Required</span>
                To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
              </div>
            </div>
        </div>
    </body>
</html>
