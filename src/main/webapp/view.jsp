<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="dao.CustomerDao,dao.PhoneDao,model.cust"%>

<%
response.setContentType("text/html");  
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
%>