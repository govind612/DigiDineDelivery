<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.food.model.Restaurant, javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Restaurant List</title>
    <link rel="stylesheet" href="style.css"> <!-- Add your CSS file here --> <style>
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
<header>
        <div class="container">
            <div id="branding">
                <h1>Home</h1>
            </div>
            <nav>
                <ul>
                    <li><a href="restaurant.jsp">Restaurant</a></li>
                    <li><a href="menu.jsp">Menu</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                    <li><a href="orderhistory.jsp">My Orders</a>
                    <li><a href="profile.jsp">Profile</a></li>
                </ul>
            </nav>
        </div>
    </header>
<div class="container"><h1>Restaurant List</h1>
    <section class="products__list">        
    
        <% 
            List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantsLists");
            System.out.println("Fetched restaurant list in JSP: " + restaurantList);
            if (restaurantList != null && !restaurantList.isEmpty()) { 
        %>
   
        <% for (Restaurant restaurant : restaurantList) { %>        
        <div class="product__card">
            <a href="menu?restaurant_id=<%= restaurant.getRestaurantId() %>">
                <div class="card__preview" style="background-image: url('<%= restaurant.getImgpath() %>');">
                    <span class="card__preview--badge">Featured</span>
                </div>
            </a>
            <div class="card__content">
                <div class="card__content-left">
                    <div class="card__content--title"><%= restaurant.getname()%></div>
                    <div class="card__content--info">
                        <div class="card__content--cook-time">
                            <img src="./img/products/icons/clock.svg" alt="Cook time">
                            <%= 30 %> mins
                        </div>
                        <span class="card__content--tag-dot"></span>
                        <div class="card__content--price">
                            $<%= 200 %> min sum
                        </div>
                    </div>
                    <!-- Removed categories list -->
                </div>
            </div>
        </div>
        <% } %>
        <% } else { %>
        <a href="home.jsp">Home</a> 
        <a href="cartServlet">Cart</a>
        <a href="profile.jsp">Profile</a>
        <a href="orderHistoryServlet">Order History</a>
        
        <h1>Restaurant List</h1>
        <p>No restaurants available.</p>
        <% } %>
    </section>
</div>

</body>
</html>
