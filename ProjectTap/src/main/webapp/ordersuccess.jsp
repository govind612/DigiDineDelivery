<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Order Completed</title>
    <style>
        /* Reset some default browser styles */
        body, h1, a {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        /* Style the body */
        body {
            background-color: #f4f4f4;
            margin: 20px;
        }

        /* Container for the main content */
        .container {
            max-width: 800px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        /* Style the navigation links */
        nav {
            margin-bottom: 20px;
            display: flex;
            gap: 10px;
        }

        nav a {
            text-decoration: none;
            color: #333;
            padding: 10px 15px;
            background-color: #e2e2e2;
            border-radius: 5px;
            transition: background-color 0.3s, color 0.3s;
        }

        nav a:hover {
            background-color: #ccc;
            color: #000;
        }

        /* Style the heading */
        h1 {
            color: #333;
            font-size: 2em;
            margin-bottom: 20px;
            text-align: center;
        }

        /* Additional styling for the body text */
        p {
            color: #666;
            line-height: 1.6;
        }

        /* Responsive adjustments */
        @media (max-width: 600px) {
            .container {
                padding: 15px;
            }

            nav {
                flex-direction: column;
                align-items: center;
            }

            nav a {
                padding: 8px 12px;
                font-size: 14px;
            }

            h1 {
                font-size: 1.5em;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <nav>
            <a href="cartServlet">Cart</a>
            <a href="ProfileServlet">Profile</a>
            <a href="orderHistoryServlet">Order History</a>
        </nav>
        
        <h1>Order Completed</h1>
        <p>Your order has been successfully completed. Thank you for shopping with us!</p>
        <% System.out.print("completed"); %>
    </div>
</body>
</html>
