package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Josepd
 */
public class servletRegisterUser extends HttpServlet {

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
        //RequestDispatcher rd = request.getRequestDispatcher("jsp/register.jsp");
        
        response.sendRedirect("index.jsp?mylink=register");

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
        //RequestDispatcher rd = request.getRequestDispatcher("jsp/register.jsp");
        //RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        response.sendRedirect("index.jsp?mylink=register");
        //rd.forward(request, response);
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
        
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        String passwordmd5 = password;
        try {
            passwordmd5 = toMD5(password);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(servletRegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        User newUser = new User(name, lastName, email, nickname, passwordmd5);
        ConnectionJDBC.connect();
        int i;
        RequestDispatcher rd;
        if (!ConnectionJDBC.exists(nickname)) {
            session = request.getSession();
            i = ConnectionJDBC.addUser(newUser);
            ConnectionJDBC.disconnect();
            response.sendRedirect("index.jsp?nickname="+nickname+"&mylink=register-Result");
            //rd = request.getRequestDispatcher("WEB-INF/jsp/register-Result.jsp");
            
        }else {
            ConnectionJDBC.disconnect();
            response.sendRedirect("index.jsp?mylink=register-Error");
            //rd = request.getRequestDispatcher("WEB-INF/jsp/register-Error.jsp");
            
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
