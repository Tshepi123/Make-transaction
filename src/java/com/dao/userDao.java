package com.dao;

import com.bean.userBean;
import com.connection.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDao {   
    private Connection conn;
    
    public userDao(Connection conn) {
        super();
        this.conn = conn;
    }
    
    public boolean addUser(userBean UB) // Creating method addUser, which will be used to add a user into database. Will be used in userServlet
    {
        boolean f = false;

        try {
            String query = "insert into users(name, surname, email, idNum, phoneNo, loginUsername, loginPassword) values(?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, UB.getName());
            ps.setString(2, UB.getSurname());
            ps.setString(3, UB.getEmail());
            ps.setString(4, UB.getIdNum());
            ps.setString(5, UB.getPhoneNo());
            ps.setString(6, UB.getLoginUsername());
            ps.setString(7, UB.getLoginPassword());
            int i = ps.executeUpdate();
            if(i==1)
            {
                f=true;
            }    
        } catch(Exception e) {
            e.printStackTrace();
        }
        return f;
    } 
    
    public userBean loginUser(userBean UB) // Creating method loginUser which will be used in loginServlet
    {
        userBean user = null; // Declaring the userBean
        try {
            String query = "select * from users where loginUsername=? and loginPassword=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, UB.getLoginUsername());
            ps.setString(2, UB.getLoginPassword());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                user = new userBean();
                user.setId(rs.getInt("id")); //(UserID)
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setIdNum(rs.getString("idNum"));
                user.setPhoneNo(rs.getString("phoneNo"));
                user.setLoginUsername(rs.getString("loginUsername"));
                user.setLoginPassword("loginPassword");
            }    
        }catch(Exception e) {
            e.printStackTrace();       
        }
        return user;
    }
    
}