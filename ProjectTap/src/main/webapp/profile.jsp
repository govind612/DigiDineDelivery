<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.food.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Profile</title>
       <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        header {
            background: #333;
            color: #fff;
            padding-top: 30px;
            min-height: 70px;
            border-bottom: #77aaff 3px solid;
        }
        header a {
            color: #fff;
            text-decoration: none;
            text-transform: uppercase;
            font-size: 16px;
        }
        header ul {
            padding: 0;
            list-style: none;
        }
        header li {
            float: left;
            display: inline;
            padding: 0 20px 0 20px;
        }
        header #branding {
            float: left;
        }
        header #branding h1 {
            margin: 0;
        }
        header nav {
            float: right;
            margin-top: 10px;
        } table {
            width: 100%;
            margin: 20px 0;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #333;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        .center {
            text-align: center;
        }</style>
</head>
<body>
 <header>
        <div class="container">
            <div id="branding">
                <h1>Profile</h1>
            </div>
            <nav>
                <ul>
                    <li><a href="home.jsp">Home</a></li>
                    <li><a href="menu.jsp">Menu</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                    <li><a href="orderhistory.jsp">Order History</a></li>
                </ul>
            </nav>
        </div>
    </header><div class="container">
    <h1>User Profile</h1>
    
    <%
        User user = (User) session.getAttribute("loggedin");
    System.out.println("User in profile.jsp: " + user); if (user != null) {
    %>     <img alt="logo5.png" src="logo5.png" height="100px" width="140px">
    
        <table border="1">
            <tr>
                <th>User ID</th>
                <td><%= user.getUserId() %></td>
            </tr>
            <tr>
                <th>Username</th>
                <td><%= user.getUsername() %></td>
            </tr>   <tr>
                <th>Email</th>
                <td><%= user.getEmail() %></td>
            </tr>   <tr>
                <th>Password</th>
                <td><%= user.getPassword() %></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><%= user.getAddress() %></td>
            </tr>
            <tr>
                <th>Role</th>
                <td><%= user.getRole()%></td>
            </tr>
        </table></div>
    <%
        } else {
    %>
        <p>User not found. Please log in.</p>
        <img alt="logo5.png" src="logo.png"height="200px" width="200px">
    <%
        }
    %>
<!-- 
    <a href="home.jsp">Back to Home</a> -->
</body>
</html>