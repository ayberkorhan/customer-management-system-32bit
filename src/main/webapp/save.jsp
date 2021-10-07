<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="dao.CustomerDao,dao.PhoneDao,model.cust"%>

<%

String name=request.getParameter("FirstName");  
String lastname=request.getParameter("LastName");  
String ID=request.getParameter("ID");  
String Phone_number=request.getParameter("Phone_number");
String Store_Name=request.getParameter("Store_Name");



  
cust e=new cust();  
e.setId(ID);  
e.setName(name);  
e.setPassword(lastname);  
e.setPhone_number(Phone_number);
e.setStore_Name(Store_Name);



String arrayphone[] = Phone_number.split(",");




PhoneDao pdao = new PhoneDao();


CustomerDao csave= new CustomerDao();
int status=csave.save(e);
int status1 = pdao.save(e,arrayphone);

status=csave.savestory(e);


%>







