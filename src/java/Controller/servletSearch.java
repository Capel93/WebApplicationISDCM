/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Client.SearchVideoService_Service;
import Client.Video;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author JoanMarc
 */
public class servletSearch extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebServiceSOAP/SearchVideoService.wsdl")
    private SearchVideoService_Service service;

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
        HttpSession session = request.getSession();
        
        if(session.getAttribute("user")==null){
            response.sendRedirect("index.jsp?mylink=login");
        }else{
            
            RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/index.jsp?mylink=search");
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
        List<Video> videos = new ArrayList<Video>();
        String searchType = request.getParameter("searchType");
        if(searchType.equals("title")){
            String title = request.getParameter("title");
            videos = searchWithVideoTitle(title);
        }
        if(searchType.equals("author")){
            String author = request.getParameter("author");
            videos = searchVideoWithAuthor(author);
        }
        if(searchType.equals("year")){
            String creationYear = request.getParameter("year");
            videos = searchVideoWithCreationYear(Integer.parseInt(creationYear));
            
        }
        
        if (videos.isEmpty()) request.setAttribute("listvideos",null);
        else request.setAttribute("listvideos",changeClass(videos));
        request.setAttribute("searchType",searchType);
        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/index.jsp?mylink=videos");
        reqDispatcher.forward(request,response);
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

    private java.util.List<Client.Video> searchVideoWithAuthor(java.lang.String author) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        Client.SearchVideoService port = service.getSearchVideoServicePort();
        return port.searchVideoWithAuthor(author);
    }

    private java.util.List<Client.Video> searchVideoWithCreationYear(int year) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        Client.SearchVideoService port = service.getSearchVideoServicePort();
        return port.searchVideoWithCreationYear(year);
    }

    private java.util.List<Client.Video> searchWithVideoTitle(java.lang.String title) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        Client.SearchVideoService port = service.getSearchVideoServicePort();
        return port.searchWithVideoTitle(title);
    }
    public ArrayList<Model.Video> changeClass(List<Client.Video> cVideos){
        ArrayList<Model.Video> videos = new ArrayList<Model.Video>();
        for (Client.Video v : cVideos) {
            Model.Video mVideo = new Model.Video(v.getId(), v.getTitle(), v.getAuthor(),v.getCreationDate(), v.getDuration()
                    , v.getViews(), v.getDescription(), v.getFormat(), v.getUrl(), v.getUploader());
            videos.add(mVideo);
        }
        return videos;
    }
    

}
