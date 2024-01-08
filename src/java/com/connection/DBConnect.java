package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    
    private static Connection conn=null;   
    public static Connection getConn()
    {
        try {
            if(conn==null)
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //This is the database Driver
                conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" //This is the database Url
                + "databaseName=InternetBankingDB;"
                + "userName=Tshepi;"
                + "password=1234;"        
                + "trustServerCertificate=true;"
                + "encrypt=true;");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }     
}