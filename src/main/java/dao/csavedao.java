package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import deneme99.cust;

public class csavedao implements daos {

	public static int save(cust e){  
        int status=0;  
        try{  
            Connection con=custdao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into Customers(LastName,FirstName) values (?,?)");  
        
            ps.setString(1,e.getLastName());  
            ps.setString(2,e.getFirstName());  
              
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
	
	public static List<cust> getAll(){  
        List<cust> list=new ArrayList<cust>();  
        try{  
            Connection con=custdao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Customers AS T1  INNER JOIN Phone T2 on T1.ID = T2.ID");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                cust e=new cust();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4)); 
                e.setPhone_number(rs.getString(5));
                e.setID(rs.getInt(6));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    } 
	
}
