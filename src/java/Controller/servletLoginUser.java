/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.*;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class servletLoginUser extends HttpServlet {

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
        response.sendRedirect("index.jsp?mylink=index");
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
        
        response.sendRedirect("index.jsp?mylink=login");
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
        
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        String passwordmd5 = password;
        try {
            passwordmd5 = toMD5(password);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(servletRegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConnectionJDBC.connect();
        int i;
        RequestDispatcher rd;
        if (ConnectionJDBC.exists(nickname,passwordmd5)) {
            HttpSession session = request.getSession(true);
            ConnectionJDBC.disconnect();
            session.setAttribute("user", nickname);
            session.setMaxInactiveInterval(30*60);
            //Cookie userName = new Cookie("user", nickname);
            //userName.setMaxAge(30*60);
            //response.addCookie(userName);
            response.sendRedirect("index.jsp?mylink=mainPage&nickname="+nickname);

            
        }else {
            ConnectionJDBC.disconnect();
            response.sendRedirect("index.jsp?mylink=index&nickname=null");
            
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
    
     private String toMD5(String original) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(original.getBytes());
	byte[] digest = md.digest();
	StringBuffer sb = new StringBuffer();
	for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
	}

	return sb.toString();
    }

}
