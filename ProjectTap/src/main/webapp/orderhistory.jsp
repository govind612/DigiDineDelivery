<%@ page import="java.util.List" %>
<%@ page import="com.food.model.OrderHistory" %>
<%@ page import="com.food.DAOImp.OrderHistoryDAOImp,com.food.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
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
                <h1>Order History</h1>
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
    <div class="container">
        <h2 class="center">Your Order History</h2>
<%--         <table>
            <tr>
                <th>Order ID</th>
                <th>User ID</th>
                <th>User Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Status</th>
                <th>Total Amount</th>
                <th>Order Date</th>
                <th>Created At</th>
            </tr>
            <%
                int userId = (Integer) session.getAttribute("user_id");
                OrderHistoryDAOImp orderHistoryDAO = new OrderHistoryDAOImp();
                List<OrderHistory> orderHistories = orderHistoryDAO.getOrderHistoriesByUser(userId);

                for (OrderHistory orderHistory : orderHistories) {
            %>
            <tr>
                <td><%= orderHistory.getOrderId() %></td>
                <td><%= orderHistory.getUserId() %></td>
                <td><%= orderHistory.getUserName() %></td>
                <td><%= orderHistory.getEmail() %></td>
                <td><%= orderHistory.getAddress() %></td>
                <td><%= orderHistory.getStatus() %></td>
                <td><%= orderHistory.getTotalAmount() %></td>
                <td><%= orderHistory.getOrderDate() %></td>
                <td><%= orderHistory.getCreatedAt() %></td>
            </tr>
            <% } %>
        </table> --%>
        <table class="center">
    <thead>
        <tr>
            <th>Order ID</th>
            <th>User ID</th>
            <th>User Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Status</th>
            <th>Total Amount</th>
            <th>Order Date</th>
            <th>Created At</th>
        </tr>
    </thead>
    <tbody>
        <%     
        	HttpSession seesion= request.getSession(false);
        User loggedin = (User) session.getAttribute("loggedin");
        Integer userId= loggedin.getUserId();
        
        OrderHistoryDAOImp orderHistoryDAO = new OrderHistoryDAOImp();
        List<OrderHistory> orderHistories = orderHistoryDAO.getOrderHistoriesByUser(userId);
        for (OrderHistory orderHistory : orderHistories) {
            %>
            <tr>
                <td><%= orderHistory.getOrderId() %></td>
                <td><%= orderHistory.getUserId() %></td>
                <td><%= orderHistory.getUserName() %></td>
                <td><%= orderHistory.getEmail() %></td>
                <td><%= orderHistory.getAddress() %></td>
                <td><%= orderHistory.getStatus() %></td>
                <td><%= orderHistory.getTotalAmount() %></td>
                <td><%= orderHistory.getOrderDate() != null ? orderHistory.getOrderDate() : "N/A" %></td>
                <td><%= orderHistory.getCreatedAt() != null ? orderHistory.getCreatedAt() : "N/A" %></td>
            </tr>
        <% }
        %>
    </tbody>
</table>
        
    </div>
</body>
</html>
