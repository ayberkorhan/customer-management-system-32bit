package dao;

import java.sql.*;

import javax.sql.DataSource;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDao extends ConnectionDao {  
public static boolean validate(String name,String pass){  
boolean status=false;  
DataSource ds = myDataSource();
Connection con = null;
try{
	con= ds.getConnection();

	
PreparedStatement ps=con.prepareStatement(  
"select * from admin where name=? and pass=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  