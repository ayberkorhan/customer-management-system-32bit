<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="dao.CustomerDao,dao.PhoneDao,model.cust"%>

<%if( request.isUserInRole("admin")|| request.isUserInRole("gosterme")){ %>
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="ISO-8859-1">  
<title>Insert title here</title>  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<%
response.setContentType("text/html");  
out.println("<h1>Customer Phone List</h1>");  

PhoneDao pview= new PhoneDao();
  
List<cust> list=pview.getAll();  

%>
<table class="table table-striped">
<thead>
  <tr>
    <th scope="col">id</th>
    <th scope="col">ad</th>
    <th scope="col">soyad</th>
    <th scope="col">telno</th>
    <th scope="col">market</th>
    
  </tr>
</thead>
  <%

for(cust e:list){  
 out.print("<tr><td>"+e.getID()+"</td><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+"</td><td>"+e.getPhone_number()+"</td><td>"+e.getStore_Name()+"</td></tr>");  
}  
out.print("</table>");  
%>
  <a href="logout.jsp" class="btn btn-info" role="button">Click to Logout</a>
  <a href="index.jsp" class="btn btn-info" role="button">Add New Customer Phone</a>


<%}else{ %>
<p> Not Access That Page </p>
<a href="index.jsp">Please Return Page</a>
      <% } %>
      
  </table> 
    </body> 
      </html> 