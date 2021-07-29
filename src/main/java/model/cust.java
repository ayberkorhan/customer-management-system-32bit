package model;

import java.util.ArrayList;

import java.util.List;


public class cust {  
private int PID;  
private Object ID;
private String FirstName,LastName,Email ,Phone_number;  
private List<String> Phone_numbe = new ArrayList<String>();
public Object getID() {  
    return ID;  
}  
public void setId(Object ID) {  
    this.ID = ID;  
}  
public String getFirstName() {  
    return FirstName;  
}  
public void setName(String FirstName) {  
    this.FirstName = FirstName;  
}  
public String getLastName() {  
    return LastName;  
}  
public void setPassword(String LastName) {  
    this.LastName = LastName;  
}  
public String getEmail() {  
    return Email;  
}  
public void setEmail(String Email) {  
    this.Email = Email;  
}  




public int getPID() {  
    return PID;  
}  
public void setID(int PID) {  
    this.PID = PID;  
}  
public String getPhone_number() {  
    return Phone_number;  
}  
public void setPhone_number(String Phone_number) {  
    this.Phone_number = Phone_number;  
}  









public List<String> getPhone_numbe() {
    return Phone_numbe;
}

public void setPhone_numbe(ArrayList<String> Phone_numbe)
{
    this.Phone_numbe = Phone_numbe;
}





  
}  