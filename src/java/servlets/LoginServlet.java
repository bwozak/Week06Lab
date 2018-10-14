/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UserService;

/**
 *
 * @author 672762
 */
public class LoginServlet extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getSession().getAttribute("username") == null) {
           
            Cookie[] cookie = request.getCookies();
            
            for (Cookie c : cookie) {
                if (c.getName().equals("username")) {
                    request.setAttribute("username", c.getValue());
                    request.setAttribute("rememberMe", "checked");
                }
            }
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else {
            
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
        
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        HttpSession session = request.getSession();
        
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserService us = new UserService();
        
        if(username.equals("") || username == null || password.equals("") || password == null || (us.login(username, password) == null))
        {
            request.setAttribute("message", "Invalid login");
            request.setAttribute("${username}", username);
            
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else {
            
            session.setAttribute("username", username);
            
            if(request.getParameter("rememberMe") != null) {
                Cookie c = new Cookie("username", username);
                response.addCookie(c);
            } else {
                Cookie[] cookie = request.getCookies();
                for(Cookie c : cookie)
                {
                    if(c.getName().equals("username"))
                    {
                        c.setMaxAge(0);
                        response.addCookie(c);
                    }
                }
            }
            
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
    }
}
