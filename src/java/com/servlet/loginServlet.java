package com.servlet;

import com.bean.userBean;
import com.connection.DBConnect;
import com.dao.userDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// This login servlet correlates with the userBean and the userDao, (using information from these Java Classes).
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
            
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()) {
            
            String loginUsername = request.getParameter("loginUsername");
            String loginPassword = request.getParameter("loginPassword");

            userBean UB = new userBean();
            UB.setLoginUsername(loginUsername);
            UB.setLoginPassword(loginPassword);
                    
            userDao dao = new userDao(DBConnect.getConn());
            userBean user = dao.loginUser(UB); //Calling method (loginUser) from userDao

            if(user != null) 
            {
                HttpSession session = request.getSession();
                session.setAttribute("userB", user);   //userB (short for userBean) Pass on to navbar and payment_form.jsp
                response.sendRedirect("home.jsp");
            }
            else {
                HttpSession session = request.getSession();
                session.setAttribute("login-failed", "Invalid Username and Password");
                response.sendRedirect("login.jsp");
            }
        }
    }
}
  