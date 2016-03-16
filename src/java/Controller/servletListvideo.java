/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Model.Video;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JoanMarc
 */
public class servletListvideo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletListvideo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletListvideo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*String user = null;
        if(request.getAttribute("user") == null){
            response.sendRedirect("/servletLoginUser");
        }else user = (String) request.getAttribute("user");
        String userName = null;
        String sessionID = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")) userName = cookie.getValue();
                if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
            }
        }
        ConnectionJDBC.connect();
        ArrayList<Video> videos = ConnectionJDBC.getVideos();
        
        
        String message = "Example source code of Servlet to JSP communication.";
        request.setAttribute("listvideos", videos);
        */
        ConnectionJDBC.connect();
        ArrayList<Video> videos = ConnectionJDBC.getVideos();
        ConnectionJDBC.disconnect();
        request.setAttribute("listvideos",videos );
        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/index.jsp?mylink=videos");
        reqDispatcher.forward(request,response);
        
        
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
        String strUserMsg = null;
        HttpSession session;
        
        
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String creation_date = request.getParameter("creation_date");
        String duration = request.getParameter("duration");
        String views = request.getParameter("views");
        String description = request.getParameter("description");
        String format = request.getParameter("format");
        String url = request.getParameter("url");
        String uploader = request.getParameter("uploader");
        
        Video video = new Video(title,author,creation_date,duration,Integer.parseInt(views),description,format,url,uploader);
        ConnectionJDBC.connect();
        int i;
        RequestDispatcher rd;
        
        ConnectionJDBC.connect();
        i = ConnectionJDBC.addVideo(video);
        ConnectionJDBC.disconnect();
        if(i<0){
            response.sendRedirect("index.jsp?mylink=videos");
        }else{
            response.sendRedirect("index.jsp?mylink=error");
        }
                
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
