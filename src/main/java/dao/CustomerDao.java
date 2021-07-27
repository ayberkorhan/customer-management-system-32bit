package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.cust;

public class CustomerDao extends ConnectionDao implements Idaos  {

	public int save(cust e)  {  
        int status=0;  
        
        Connection con=getConnection();  
        try{  
            
        	String sql ="insert into Customers(LastName,FirstName) values (?,?)";
        	        	
        	PsMetodu(sql,con);
            //PreparedStatement ps=con.prepareStatement(  
                         //"insert into Customers(LastName,FirstName) values (?,?)");  
        
            ps.setString(1,e.getLastName());  
            ps.setString(2,e.getFirstName());  
              
            status=ps.executeUpdate();                
            con.close();
             
        }catch(Exception ex){ex.printStackTrace();}
        finally {
        	 try {
				ps.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
        	 try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	 
        }
          
        return status;  
    }  
	
	

	public  List<cust> getAll(){  
        List<cust> list=new ArrayList<cust>();  
        try{  
            Connection con=getConnection();  
            
            
           // PreparedStatement ps=con.prepareStatement("select * from Customers AS T1  INNER JOIN Phone T2 on T1.ID = T2.ID"); 
            PsMetodu("select * from Customers AS T1  INNER JOIN Phone T2 on T1.ID = T2.ID",con);
            
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






  





