   

    package serv;
    import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.ServletException;  
    import javax.servlet.annotation.WebServlet;  
    import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;

import dao.csavedao;
import dao.custdao;
import deneme99.cust;
import deneme99.phone;  
    @WebServlet("/SaveServlet")  
    public class SaveServlet extends HttpServlet {  
        protected void doPost(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
              
            String name=request.getParameter("FirstName");  
            String password=request.getParameter("LastName");  
            String email=request.getParameter("ID");  
            
            cust e=new cust();  
            e.setName(name);  
            e.setPassword(password);  
            e.setEmail(email);  
            
            /*int ID=Integer.parseInt("ID");
            int Phone_number=Integer.parseInt("Phone_number");
            
           
            phone d=new phone();  
            d.setId(ID);  
            d.setPhone_number(Phone_number);  */
              
            int status=csavedao.save(e);  
            if(status>0){  
                out.print("<p>Record saved successfully!</p>");  
                request.getRequestDispatcher("index.html").include(request, response);  
            }else{  
                out.println("Sorry! unable to save record");  
            }  
              
            out.close();  
        }  
      
    }  