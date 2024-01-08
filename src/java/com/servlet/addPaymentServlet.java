package com.servlet;

import com.bean.paymentBean;
import com.connection.DBConnect;
import com.dao.paymentDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "addPaymentServlet", urlPatterns = {"/addPaymentServlet"})
public class addPaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        int userID = Integer.parseInt(request.getParameter("userID"));
        String accNo = request.getParameter("accNo");
        String receiverAccNo = request.getParameter("receiverAccNo");
        String amount = request.getParameter("amount");

        paymentDao dao = new paymentDao(DBConnect.getConn());
        boolean f = dao.AddPayment(accNo, receiverAccNo, amount, userID);  
        HttpSession session;
        
          if(f)
        {
            session = request.getSession();
            System.out.println("Data Inserted Successfully"); //This message will show in console(view server output) below if data from payment_form.jsp has been inserted into the database table (payment) Go to database and enter {select * from HomeAffairsDB.dbo.payment) To see new inserted data
            session.setAttribute("addPayment-successMsg", "Payment Made Successfully"); // Setting this error message to be shown on web app once added/made payment successfully. This attribute will be used in payment_form.jsp page 
            response.sendRedirect("payment_form.jsp"); 
        } 
        else
        {
            session = request.getSession();
            System.out.println("Data NOT Inserted Successfully"); //This message will show in console(view server output) below if data from payment_form.jsp has NOT been inserted into the database table (payment)
            session.setAttribute("addPayment-errorMsg", "Payment NOT Made, Please try again"); // Setting this error message to be shown on web app if payment have not been added(Error in server/ system). This attribute will be used in payment_form.jsp page 
            response.sendRedirect("payment_form.jsp"); // Will redirect to the same page to re-enter values in the form.
        }  
    }   
    // *NB To access console, go to services(in between Projects and Files), toggle down to Servers, then right click on Apache Tomcat
}