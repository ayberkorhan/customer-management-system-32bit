<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%if( request.isUserInRole("admin")|| request.isUserInRole("ekleme")){ %>
    
    <!DOCTYPE html>  
    <html>  
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <head>  
    <meta charset="ISO-8859-1">  
    <title>Insert title here</title>  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>  
          <body>
<div class="container">
  <h1>Add New Customer:</h1>
  <div class="card">
   <div class="card-body">
    <form a method="post">

     <div class="form-group row">
      <label for="firstName" class="col-sm-2 col-form-label">First
       Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="firstName" id="FirstName"
        placeholder="Enter first name">
      </div>
     </div>

     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Last
       Name</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="lastName" id="LastName"
        placeholder="Enter last name">
      </div>
     </div>

     <div class=" form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">ID
       </label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="ID" id="ID"
        placeholder="Enter user name">
      </div>
     </div>

     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Phone Number</label>
      <div class="col-sm-7">
       <input type="password" class="form-control" name="Phone_number" id="Phone_number"
        placeholder="Enter Password">
      </div>
     </div>

     <div class="form-group row">
      <label for="lastName" class="col-sm-2 col-form-label">Market</label>
      <div class="col-sm-7">
       <input type="text" class="form-control" name="Store_Name" id="Store_Name"
        placeholder="Enter Address">
      </div>
     </div>

     

     <button type="submit" class="btn btn-primary" id="save_data" >Submit</button>
     <br/> 
     <br/> 
      <a href="view.jsp" class="btn btn-primary" role="button">view CustomerPhones</a>
      <a href="logout.jsp" class="btn btn-primary" role="button">Click to Logout</a>
      <script>
$(document).ready(function() {
$("#save_data").click(function() {
alert("succeess");
$.ajax({
url: "save.jsp",
type: "post",
data: {
FirstName:$('#FirstName').val(),
LastName:$('#LastName').val(),
ID:$('#ID').val(),
Phone_number:$('#Phone_number').val(),
Store_Name:$('#Store_Name').val(),
success : function(data){
alert(data);
}
}
});
});
});
</script>
    
    </form>
   </div>
  </div>
</div>
   <br/>  
  
   
</body>

    <%}else{ %>
<p> Not Access That Page </p>
<a href="view.jsp">Please Return Page</a>
      <% } %>
      
      
    </html>  
      
      
      

      
      