package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.cust;

public class PhoneDao extends ConnectionDao implements Idaos {

    public  int save(cust e,String arr[]){  
        int status=0;  
        //Connection con=getConnection();  
        //Connection con=(Connection) myDataSource();
        DataSource ds = myDataSource();
        Connection con = null;
        try{  
        	con= ds.getConnection();

            //PreparedStatement ps=con.prepareStatement(  
                         //"insert into Phone(ID,Phone_number) values (?,?)");  
        	PsMetodu("insert into Phone(ID,Phone_number) values (?,?)",con);
        
           // ps.setString(1,e.getID().toString());  
            //ps.setString(2, e.getPhone_number());
            
            
            for (int i = 0; i < arr.length; i++) {
                ps.setObject(1, e.getID());
                String tempString = arr[i];
                ps.setString(2, tempString);


                
                status = ps.executeUpdate();
            }
            
            
            
              
              
            //status=ps.executeUpdate();  
              
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
        DataSource ds = myDataSource();
        Connection con = null;
        try{  
            //Connection con=getConnection(); 
        	con= ds.getConnection();
            
            //PreparedStatement ps=con.prepareStatement("select T1.FirstName,T1.LastName,GROUP_CONCAT(distinct T2.Phone_number) num\n"
            		//+ "from Customers AS T1  INNER JOIN Phone T2 on T1.ID = T2.ID GROUP BY T1.ID  ");  
            PsMetodu("SELECT T1.ID, T1.FirstName,T1.LastName,  T1.Phone_number , Store_Name From Stores s  \n"
            		+ "INNER JOIN (SELECT c.ID , c.FirstName , c.LastName , GROUP_CONCAT(Phone_number) as Phone_number \n"
            		+ "From Customers as c  INNER JOIN Phone as cp ON c.ID = cp.ID \n"
            		+ "GROUP BY c.ID) T1    ON T1.ID= s.ID ",con);
            
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
  
                cust e=new cust(); 
                e.setId(rs.getObject(1));
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setPhone_number(rs.getString(4));
                e.setStore_Name(rs.getString(5));
                 
                list.add(e);  
                
              
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }
	
}
