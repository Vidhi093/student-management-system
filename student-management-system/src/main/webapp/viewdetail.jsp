<%@ page import="com.jsp.model.Student" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <title>User Dashboard</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: sans-serif;
      background: linear-gradient(#141e30, #243b55);
      display: flex;
      justify-content: center;
      align-items: center;
      height: 150vh;
    }

    .dashboard-box {
      width: 500px;
      padding: 40px;
      background: rgba(0, 0, 0, .5);
      box-sizing: border-box;
      box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
      border-radius: 10px;
      color: #fff;
      text-align: center;
    }

    .dashboard-box h2 {
      margin: 0 0 30px;
      padding: 0;
    }

    .info {
      display: flex;
      text-align: center;
      justify-content: space-between;
    }

    .data {
      margin-right: 10px;
    }

    .showpass {
      display: flex;
    }

    .password {
      display: none;
    }

    .show-password:checked+.data {
      display: inline;
    }

    .dashboard-box a {
      display: inline-block;
      padding: 10px 20px;
      color: #03e9f4;
      font-size: 16px;
      text-decoration: none;
      text-transform: uppercase;
      transition: .5s;
      margin-top: 40px;
      letter-spacing: 4px;
      border-radius: 5px;
    }

    .dashboard-box a:hover {
      background: #03e9f4;
      color: #fff;
      box-shadow: 0 0 5px #03e9f4,
        0 0 25px #03e9f4,
        0 0 50px #03e9f4,
        0 0 100px #03e9f4;
    }
  </style>
</head>

<body>

<%
        Student student = (Student)request.getAttribute("student");
		
    %>
  <div class="dashboard-box">
    <h2>Student Details</h2>

    <div class="info">
      <p>Name : </p>
      <p class="data"><%= student.getName() %></p>
    </div>

    <div class="info">
      <p>Email :</p>
      <p class="data"><%= student.getEmail() %></p>
    </div>

    <div class="info">
      <p>Username :</p>
      <p class="data"><%= student.getUsername() %></p>
    </div>
    
    <div class="info">
      <p>Contact :</p>
      <p class="data"><%= student.getContact() %></p>
    </div>

    <div class="info">
      <p>Gender:</p>
      <p class="data"><%= student.getGender() %></p>
    </div>

 <div class="info">
      <p>Address:</p>
      <p class="data"><%= student.getAddress() %></p>
    </div>

    <div class="info">
      <p>Branch :</p>
      <p class="data"><%= student.getBranch() %></p>
    </div>

 
    <div class="info">
      <label for="password">Password:</label>
      <input type="checkbox" class="show-password">
      <p class="data password"><%= student.getPassword() %></p>
    </div>

    <a href="updateform.html">Update</a>
    
   <!--<a href="deletedetail.jsp?username=<%= student.getUsername() %>">Delete</a>  --> 
   <a href="deleteform.html">Delete</a> 
   <a href="loginform.html">Go to Home Page</a>
  </div>

</body>

</html>
