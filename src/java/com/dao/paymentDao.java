package com.dao;

import com.bean.paymentBean;
import com.bean.userBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class paymentDao {
    
    private Connection conn;
    
    public paymentDao(Connection conn) {
        super();
        this.conn = conn;
    }
    
    //accNo = accountNumber, recAccNo = receiverAccNo, am = amount, ui = userID (Setting Parameters)
    public boolean AddPayment(String accNo, String recAccNo, String am, int ui) //Method AddPayment will insert info into database payment from payment_form.jsp using the bean class paymentBean
    {
        boolean f=false;
        try {
            String query = "insert into payment(accNo, receiverAccNo, amount, userID) values(?, ?, ?, ?)"; // Inserting into the database table (payment), the parameters from above (accNo, recAccNo, am)
            // The paymentDate will be inserted automatically into database
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,accNo);
            ps.setString(2,recAccNo);
            ps.setString(3,am);
            ps.setInt(4,ui);
            
            int i = ps.executeUpdate();
            if(i == 1)
            {
                f=true;
            }    
        } catch (Exception e) {
            
        }
        return f;
    }  
    
    // Creating ArrayList for payment_list.jsp
    public List<paymentBean> getData(int userID) // The method getData() is created to get all the info from the database table (payment)
    {
        List<paymentBean> list = new ArrayList<paymentBean>(); //Initailising the ArrayList 
        paymentBean po = new paymentBean(); // Initialising the bean class
        
        try {
            
            String query = "select * from payment where userID = ?"; // selecting all data from the payment table from database, by the userID (foreign key) which was inserted when adding payment.  
                                                                    // This method getData will be used to show the data in payment_list.jsp
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                po.setId(rs.getInt(1)); //(PaymentID)
                po.setAccNo(rs.getString(2));
                po.setReceiverAccNo(rs.getString(3));
                po.setAmount(rs.getString(4));
                po.setPaymentDate(rs.getTimestamp(5));             //Getting the date by using Timestamp(getTimestamp) 
                list.add(po);
            }    
        } catch (Exception e) {            
        }
        return list;
    }  
}