package dao;

import java.util.*;

import model.cust;

import java.sql.*;  
  
public class ConnectionDao implements Idaos {
	 PreparedStatement ps;
	static cust e;
  
    public  Connection getConnection(){  
        Connection con=null;  
        
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alisveris","ayberk","password");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }
    
   
    
   public  PreparedStatement PsMetodu(String x,Connection con)  {
	   try {
		 ps=con.prepareStatement(x);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	   return ps;
   }


	
    
    
    
    
    
    
   
    
   
    
    
    
    
}  