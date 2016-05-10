/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Video;
import RestClient.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Josep D. Capdevila
 */
public class servletViewVideo extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
        
        if(session.getAttribute("user")==null){
            response.sendRedirect("index.jsp?mylink=login");
        }else{
            
            /*
            REST
            */
            int id = Integer.parseInt(request.getParameter("id"));
            
            int views = GetViews.ViewsGet(id);
            views += 1;
           
            PostViews.ViewsPost(id);
           
            /*
             FI REST
            */
           
           
            ConnectionJDBC.connect();
            Video video = ConnectionJDBC.getVideoById(id);
            ConnectionJDBC.disconnect();
            
            video.setViews(views);
            
            String url = video.getUrl();
            int indexOf = url.indexOf("youtube.com/watch?v="); 
            if(indexOf != -1){
                String newURL = "https://www.youtube.com/embed/" + url.substring(indexOf+20, url.length());
                video.setUrl(newURL);
                request.setAttribute("location", "youtube");
            }
            else request.setAttribute("location", "local");
            
            if (video == null) request.setAttribute("video",null);
            else request.setAttribute("video",video);
//            System.out.println(video.toString());
            RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/index.jsp?mylink=viewVideo");
            reqDispatcher.forward(request,response);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
