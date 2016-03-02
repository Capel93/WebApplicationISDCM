package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletRegisterUse</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletRegisterUse at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        HttpSession session = request.getSession();
        
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String mail = request.getParameter("mail");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        
        if (password.equals(password2)) {
            User newUser = new User(name, lastName, mail, nickname, password);
            ConnectionJDBC.connect();
            int i;
            if (!ConnectionJDBC.exists(nickname)) {
                i = ConnectionJDBC.addUser(newUser);
                RequestDispatcher rd = request.getRequestDispatcher("mainPage.jsp");
                rd.forward(request, response);
            }else {
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                try (PrintWriter out = response.getWriter()) {
                out.println("<font color=red>Nickname already used</font>");
                }
                rd.include(request, response);
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
        try (PrintWriter out = response.getWriter()) {
            out.println("<font color=red>Password not equal</font>");
        }
        
        rd.include(request, response);
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
