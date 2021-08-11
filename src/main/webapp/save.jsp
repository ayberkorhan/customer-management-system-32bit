<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="dao.CustomerDao,dao.PhoneDao,model.cust"%>

<%

String name=request.getParameter("FirstName");  
String lastname=request.getParameter("LastName");  
String ID=request.getParameter("ID");  
String Phone_number=request.getParameter("Phone_number");



  
cust e=new cust();  
e.setId(ID);  
e.setName(name);  
e.setPassword(lastname);  
e.setPhone_number(Phone_number);



CustomerDao csave= new CustomerDao();
int status=csave.save(e);
PhoneDao pdao = new PhoneDao();
int status1 = pdao.save(e);


%>