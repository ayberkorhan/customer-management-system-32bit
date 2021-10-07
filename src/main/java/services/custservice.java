package services;

import javax.annotation.security.RolesAllowed;
import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.CustomerDao;
import dao.PhoneDao;
import model.cust;
@WebService(endpointInterface = "services.Iservice")
@RolesAllowed("ekleme")
public class custservice implements Iservice {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/cust/{ID}/{FirstName}/{Lastname}/{Email}/{Phone_number}")
	public String Save(@PathParam("ID") String ID,@PathParam("FirstName") String FirstName,@PathParam("Lastname") 
	String Lastname,@PathParam("Phone_number") String Phone_number) {
		// TODO Auto-generated method stub
		
		String arrayphone[] = Phone_number.split(",");

		
		   cust e=new cust();  
		   e.setId(ID);  
		   e.setName(FirstName);  
           e.setPassword(Lastname);  
           e.setPhone_number(Phone_number);
           
          
           CustomerDao csave= new CustomerDao();
             
           int status=csave.save(e);
           PhoneDao pdao = new PhoneDao();
           int status1 = pdao.save(e,arrayphone);
           
           
           
           
           
           if(status>0){  
               return "<p>Record saved successfully!</p>";  
                
           }else{  
        	   
              return "Sorry! unable to save record"; 
              
           }  
             
           
		
           
		
		
	}
	
}
