<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.food.model.CartCreator, com.food.model.CartItems" %>
<%@ page import="java.util.LinkedHashMap" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Shopping Cart</title> <style>
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
        CartCreator cart = (CartCreator) session.getAttribute("cartCreator");
        if (cart != null) {
            LinkedHashMap<Integer, CartItems> cartItems = cart.getCartItems();
            if (cartItems != null && !cartItems.isEmpty()) {
                double total = 0.0;
                for (CartItems item : cartItems.values()) {
    %><header>
        <div class="container">
            <div id="branding">
                <h1>Home</h1>
            </div>
            <nav>
                <ul>                    <li><a href="home.jsp">Home</a></li>
                
                    <li><a href="restaurant.jsp">Restaurant</a></li>
                    <li><a href="menu.jsp">Menu</a></li>
                    <li><a href="orderhistory.jsp">My Orders</a>
                    <li><a href="profile.jsp">Profile</a></li>
                </ul>
            </nav>
        </div>
    </header>   <div class="container"> <h1>Shopping Cart</h1>
   
                    <div>
                        <h2><%= item.getItemName() %></h2>
                        <p>Price: <%= item.getPrice() %></p>
                        <p>Quantity: <%= item.getQuantity() %></p>
                        <form action="cartServlet" method="get">
                            <input type="hidden" name="menuItemId" value="<%= item.getItemId() %>">
                            <input type="hidden" name="ac" value="remove">
                            <button type="submit">Remove</button>
                        </form>
                        <form action="cartServlet" method="get">
                            <input type="hidden" name="menuItemId" value="<%= item.getItemId() %>">
                            <label for="quantity">Quantity:</label>
                            <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1">
                            <input type="hidden" name="ac" value="update">
                            <button type="submit">Update</button>
                        </form>
                    </div></div>
    <% 
                    total += item.getPrice() * item.getQuantity();
                }
    %>
                <h2>Total: <%= total %></h2>
                <a href="checkout.jsp">Checkout</a>
    <% 
            } else {
    %><header>
        <div class="container">
            <div id="branding">
                <h1>Home</h1>
            </div>
            <nav>
                <ul>          <li><a href="home.jsp">Home</a></li>
                
                    <li><a href="restaurant.jsp">Restaurant</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                    <li><a href="orderhistory.jsp">My Orders</a>
                    <li><a href="profile.jsp">Profile</a></li>
                </ul>
            </nav>
        </div>
    </header>   <div class="container"> <h1>Shopping Cart</h1>
   
                <p>Your cart is empty.</p></div>
    <% 
            }
        } else {
    %><header>
        <div class="container">
            <div id="branding">
                <h1>Home</h1>
            </div>
            <nav>
                <ul>  <li><a href="home.jsp">Home</a></li>
                
                    <li><a href="restaurant.jsp">Restaurant</a></li>
                    
                    <li><a href="cart.jsp">Cart</a></li>
                    <li><a href="orderhistory.jsp">My Orders</a>
                    <li><a href="profile.jsp">Profile</a></li>
                </ul>
            </nav>
        </div>
    </header>    <div class="container"></a><h1>Shopping Cart</h1>
   
        <p>Cart not found.</p></div>
    <% 
        }
    %>
   
</body>
</html>