<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.food.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Menu</title>   <style>
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
        }
        table {
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
        }
    </style>
</head>
<body>  
    
    <%
        List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
        if (menuList != null && !menuList.isEmpty()) {
           %>
              <header>
        <div class="container">
            <div id="branding">
                <h1>Menu</h1>
            </div>
            <nav>
                <ul>
                    <li><a href="home.jsp">Home</a></li>
                    <li><a href="menu.jsp">Menu</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                    <li><a href="profile.jsp">Profile</a></li>
                </ul>
            </nav>
        </div>
    </header><% for (Menu menu : menuList) {
    %>  <div class= "container">
                <div>
                    <h2><%= menu.getItemName() %></h2>
                    <p>Price: <%= menu.getPrice() %></p>
                    <p>Description: <%= menu.getDescription() %></p>
                    <form action="cartServlet" method="get">
                        <input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
                        <input type="hidden" name="ac" value="add">
                        <label for="quantity">Quantity:</label>
                        <input type="number" name="quantity" value="1" min="1">
                        <button type="submit">Add to Cart</button>
                    </form><br>
                </div></div>
    <%
            }
        } else {
    %>   <header>
        <div class="container">
            <div id="branding">
                <h1>Menu</h1>
            </div>
            <nav>
                <ul>
                    <li><a href="home.jsp">Home</a></li>
                    <li><a href="menu.jsp">Menu</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                    <li><a href="profile.jsp">Profile</a></li>
                </ul>
            </nav>
        </div>
    </header>
            <p>No menu items available.</p>
    <%
        }
    %><!-- 
    <a href="home.jsp">Back to Home</a> -->
</body>
</html>
