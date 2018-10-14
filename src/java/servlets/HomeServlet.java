/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 672762
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession username = request.getSession();
        
        if( username.getAttribute("username") == null) {
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
        } 
        else if( username.getAttribute("username") != null) {
            
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        
        }
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        
        HttpSession username = request.getSession();
        
        if(request.getParameter("login") != null) {
            
            username.setAttribute("username", null);
            request.setAttribute("message", "Log out successful.");
            request.getSession().invalidate();
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);   
        
        } 
        //String action = request.getParameter("action");
        
        //getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

}
