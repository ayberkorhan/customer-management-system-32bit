package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import deneme99.cust;

public class psavedao implements daos {

    public static int save(cust e){  
        int status=0;  
        try{  
            Connection con=custdao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into Phone(ID,Phone_number) values (?,?)");  
        
            ps.setInt(1,e.getPID());  
            ps.setString(2,e.getPhone_number());  
              
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
    
    public static List<cust> getAll(){  
        List<cust> list=new ArrayList<cust>();  
        try{  
            Connection con=custdao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select T1.FirstName,T1.LastName,GROUP_CONCAT(distinct T2.Phone_number) num\n"
            		+ "from Customers AS T1  INNER JOIN Phone T2 on T1.ID = T2.ID GROUP BY T1.ID  ");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
  
                cust e=new cust(); 
                e.setName(rs.getString(1));  
                e.setPassword(rs.getString(2));  
                e.setPhone_number(rs.getString(3));
                 
                list.add(e);  
                
              
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }
	
}
