<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ page import="com.food.model.User, java.util.List, javax.servlet.http.HttpServletRequest"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>   <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            
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
    </style><link href="style.css" rel="stylesheet">
</head>
<body>
<form action="/register" method="post">
<!-- 
    <p>Welcome</p><br> -->
    

<%
   
	User user =(User) session.getAttribute("loggedin");
    if (user == null) {
%>		
       <div  style="margin: 0; font-family: Arial, sans-serif; background-image: url('banner-hero-2.png'); background-size:cover  ;  ;  background-repeat:no-repeat; ; background-position:center  ;">
    <div class="container" style="display: flex-direction; justify-content: center; align-items:stretch; ; height: 100vh;">
        <div style="background-color:navy; ; margin: 200px 50px; padding: 20px; border-radius: 14px; display: flex; justify-content: space-around; width: 300px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">
            <div style="background-color: lime; padding: 10px; border-radius: 8px;">
                <a href="register.jsp" style="text-decoration: none; color: #333; font-size: 18px; font-weight: bold;">Register</a>
            </div>
            <div style="background-color: lime; padding: 10px; border-radius: 8px;">
                <a href="login.jsp" style="text-decoration: none; color: #333; font-size: 18px; font-weight: bold;">Login</a>
            </div>
        </div>
    </div>
 <%   } else {
%>   <header>
        <div class="container">
            <div id="branding">
                <!-- <h1>Home</h1> -->  <img alt="logo5.png" src="logo5.png" height="100px" width="140px">
                
            </div>
            <nav>
                <ul>
                    <li><a href="restaurant">Restaurant</a></li>
                    <li><a href="menu.jsp">Menu</a></li>
                    <li><a href="cart.jsp">Cart</a></li>
                    <li><a href="orderhistory.jsp">My Orders</a>
                    <li><a href="profile.jsp">Profile</a></li>
                </ul>
            </nav>
        </div>
    </header><!-- 
		<a href="restaurant">Restaurants</a>
        <a href="cartServlet">Cart</a>
        <a href="ProfileServlet">Profile</a>
        <a href="history.jsp">Order History</a> -->
        <div class="container">
        		<p>
              <img src="banner-hero-sec.png" alt="" height="100%" width="100%" ></p>
        <p style="font-family: 'Nunito', sans-serif; font-size: larger; line-height: 26px;">Welcome to DigiDineDelivery, where every meal is a culinary masterpiece delivered straight to your door.
          Explore a world of flavors with our diverse menu, curated from the finest ingredients and prepared by
          top chefs. Whether you're craving gourmet cuisine, comforting classics, or exotic dishes, SavorDelight
          promises a dining experience that's always fresh, delicious, and convenient. Order now and indulge in
          the delight of exceptional food, made just for you. Bon appétit!</p>
        <br><br>
        
        
    <section class="section instruction" aria-labelledby="">
        <div class="container">
          <h2 class="h2 section-title" id="instruction-label" data-reveal style="font-size: xx-large;">How It Works</h2>
          <p class="section-text" data-reveal style="font-size: large;">
            "Discover a world of flavors at your fingertips! Our food delivery app lets you explore menus, choose your favorite dishes, and have them delivered right to your doorstep. Whether you're craving comfort food or exotic cuisine, we've got you covered. Bon appétit!" 🍔🚚
          </p>
          <br><br>
          <br><br>
          <br><br>
          <ul class="grid-list" style="display: grid;">
            <li data-reveal="left">
              <div class="instruction-card">
                <figure class="card-banner" style="margin-left:-14px ;">
                  <img src="instructuion-1.png" width="300" height="154" loading="lazy"
                    alt="Select Restaurant" class="w-100">
                </figure>
                <div class="card-content">
                  <h3 class="h5 card-title">
                    <span class="span">01</span>
                    Select Restaurant
                  </h3>
                  <p class="card-text">
                    Users explore restaurant menus, scroll through the app’s feed, and find restaurants they’re interested in.
                    They can filter by cuisine type, location, or ratings.
                    High-quality images and detailed descriptions help users make informed choices.
                  </p>
                </div>
              </div>
            </li>
            <li data-reveal>
              <div class="instruction-card">
                <figure class="card-banner">
                  <img src="instructuion-2.png" width="300" height="154" loading="lazy"
                    alt="Select menu" class="w-100">
                </figure>
                <div class="card-content">
                  <h3 class="h5 card-title">
                    <span class="span">02</span>
                    Select menu
                  </h3>
                  <p class="card-text">
                    Once a user finds a restaurant, they browse its menu.
                    They select dishes they want to order by tapping on them.
                    The selected items are added to their cart for checkout.
                  </p>
                </div>
              </div>
            </li>
            <li data-reveal="right">
              <div class="instruction-card">
                <figure class="card-banner">
                  <img src="instructuion-3.png" width="300" height="154" loading="lazy"
                    alt="Wait for delivery" class="w-100">
                </figure>
                <div class="card-content">
                  <h3 class="h5 card-title">
                    <span class="span">03</span>
                    Wait for delivery
                  </h3>
                  <p class="card-text">
                    Users receive notifications when the delivery is out for delivery, arrives nearby, and when it’s delivered.
                    Delivery: The delivery person arrives, hands over the order, and confirms completion.
                  </p>
                </div>
              </div>
            </li>
          </ul>
        </div>
    </section>
        
        
        </div>
        <div class="endline">
       <div class="mindiv2">
          <p class="ep pe "><i class="fa-regular fa-copyright"></i>DigiDineDelivery</p>
       </div>
       <div class="mindiv1">
          <p class="ep">Terms&Conditions</p>
          <p class="ep">Privacy Policy</p>
          <p class="ep">Cookie Policy</p>
       </div>
    </div> 
<%
    }
%>

</form>
</body>
</html>
