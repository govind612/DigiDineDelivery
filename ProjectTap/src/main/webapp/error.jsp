<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.food.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Profile</title>
</head>
<body>
    <h1>User Profile</h1>
    
    <%request.getAttribute("errorMessage");
    System.out.print("errorMesssage");
        User user = (User) session.getAttribute("loggedin");
    System.out.println("User in profile.jsp: " + user); if (user != null) {
/*         Integer restaurantId = (Integer) session.getAttribute("restaurant_id");

    	System.out.print("user details"+ session.getAttribute("restaurant_id")); 
    	
    	
    	/* CartCreator cartCreator = (CartCreator) session.getAttribute("cartCreator");
    	System.out.print(cartCreator); */ 
    %>
        <table border="1">
            <tr>
                <th>User ID</th>
                <td><%= user.getUserId() %>    </td>
            </tr>
            <tr>
                <th>Username</th>
                <td><%= user.getUsername() %></td>
            </tr> 
             </table> <%} %>

    <a href="home.jsp">Back to Home</a>
</body>
</html>