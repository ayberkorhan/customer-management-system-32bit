package serv;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import dao.PhoneDao;
import model.cust;   

@WebServlet("/phone")  
public class phoneview extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Customer Phone</a>");  
        out.println("<h1>Customer Phone List</h1>");  
        
        PhoneDao pview= new PhoneDao();
          
        List<cust> list=pview.getAll();  
       
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>ID</th><th>isim</th><th>soyisim</th><th>telno</th></tr>");  
        for(cust e:list){  
         out.print("<tr><td>"+e.getID()+"</td><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+"</td><td>"+e.getPhone_number()+"</td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  