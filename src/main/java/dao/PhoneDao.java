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

    public  int save(cust e){  
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
        
            ps.setString(1,e.getID().toString());  
            ps.setString(2, e.getPhone_number());
            
              
              
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
        DataSource ds = myDataSource();
        Connection con = null;
        try{  
            //Connection con=getConnection(); 
        	con= ds.getConnection();
            
            //PreparedStatement ps=con.prepareStatement("select T1.FirstName,T1.LastName,GROUP_CONCAT(distinct T2.Phone_number) num\n"
            		//+ "from Customers AS T1  INNER JOIN Phone T2 on T1.ID = T2.ID GROUP BY T1.ID  ");  
            PsMetodu("select T1.ID, T1.FirstName,T1.LastName,GROUP_CONCAT(distinct T2.Phone_number) num\n"
            		+ "from Customers AS T1  INNER JOIN Phone T2 on T1.ID = T2.ID GROUP BY T1.ID  ",con);
            
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
  
                cust e=new cust(); 
                e.setId(rs.getObject(1));
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setPhone_number(rs.getString(4));
                 
                list.add(e);  
                
              
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }
	
}
