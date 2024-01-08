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

@WebServlet(name = "registrationServlet", urlPatterns = {"/registrationServlet"})
public class registrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String idNum = request.getParameter("idNum");
        String phoneNo = request.getParameter("phoneNo");
        String loginUsername = request.getParameter("loginUsername");
        String loginPassword = request.getParameter("loginPassword");

        userBean UB = new userBean();
        UB.setName(name);
        UB.setSurname(surname);
        UB.setEmail(email);
        UB.setIdNum(idNum);
        UB.setPhoneNo(phoneNo);
        UB.setLoginUsername(loginUsername);
        UB.setLoginPassword(loginPassword);
        
        userDao dao = new userDao(DBConnect.getConn());
        boolean f=dao.addUser(UB);  // using method addUser, from userDao 
        PrintWriter out = response.getWriter();
        HttpSession session;
        
        if(f)
        {
            session = request.getSession();
            session.setAttribute("reg-success", "Registered Successfully");
            response.sendRedirect("registration_form.jsp"); // Will redirect to same page once successfully registered & message above will show "Registered Successfully" (with a link that you can click on to go to the Login page).(Look at registration_form.jsp) 
        }    
        else {
            session = request.getSession();
            session.setAttribute("failed-msg", "Something went wrong on server");
            response.sendRedirect("registration_form.jsp"); // If registration has failed, will stay on registration page(registration_form.jsp) and message "something went wrong on server" will show
        }
    }
}
