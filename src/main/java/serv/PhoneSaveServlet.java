  package serv;
    import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;

import dao.ConnectionDao;
import dao.PhoneDao;
import model.cust;  
    @WebServlet("/PhoneServlet")  
    public class PhoneSaveServlet extends HttpServlet {  
        protected void doPost(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
              
            //int ID=request.getParameter("ID");  
      
            String ID=request.getParameter("ID");  
            String Phone_number=request.getParameter("Phone_number");  
            
            int ID1=Integer.parseInt(ID);
            //int phone1=Integer.parseInt(Phone_number);
            
           
            cust d=new cust();  
            d.setID(ID1);  
            d.setPhone_number(Phone_number);  
            
            PhoneDao psave= new PhoneDao();
              
            int status=psave.save(d);  
            if(status>0){  
                out.print("<p>Record PHONE saved successfully!</p>");  
                request.getRequestDispatcher("index.html").include(request, response);  
            }else{  
                out.println("Sorry! PHONE unable to save record");  
            }  
              
            out.close();  
        }  
      
    }  