package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "logoutServlet", urlPatterns = {"/logoutServlet"})
public class logoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            // Will remove attribute userB from loginServlet to close and end the program 
            HttpSession session = request.getSession();
            session.removeAttribute("userB");
            
            // Once you click Logout (on navbar) within the application, then message will show on Loginpage (above login form) that "You have Successfully Logged Out". Then will be redirected to login page(login.jsp) 
            HttpSession session2 = request.getSession();
            session.setAttribute("logoutMsg", "You Have Successfully Logged Out"); //Setting Attribute(logout message) to be used in login.jsp Then will getAttribute on login.jsp (Look at login.jsp) 
            response.sendRedirect("login.jsp");
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}