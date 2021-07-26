package dao;

import java.util.*;

import deneme99.cust;
import deneme99.phone;

import java.sql.*;  
  
public class custdao implements daos {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alisveris","ayberk","password");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
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
    
    
 /*   public static int save1(cust e){  
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
    } */
    
    
    
    
    /*public static int update(cust e){  
        int status=0;  
        try{  
            Connection con=custdao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update Customers set LastName=?,FirstName=?,mail=? where ID=?");  
            ps.setString(1,e.getLastName());  
            ps.setString(2,e.getFirstName());  
            ps.setString(3,e.getEmail());  
            ps.setInt(4,e.getID());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }*/  
    /*public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=custdao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from Customers where ID=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }*/  
   /* public static cust getcustloyeeById(int id){  
        cust e=new cust();  
          
        try{  
            Connection con=custdao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Customers where ID=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    } */ 
   /* public static List<cust> getAllcustomers(){  
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
    }  */
    
   /* public static List<cust> getAllphones(){  
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
    }*/
    
    
    
   
    
   
    
    
    
    
}  