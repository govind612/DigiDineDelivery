package com.food.Servlets;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAOImp.OrderDAOImp;
import com.food.DAOImp.OrderHistoryDAOImp;
import com.food.DAOImp.OrderItemDAOImp;
import com.food.model.CartCreator;
import com.food.model.CartItems;
import com.food.model.Order;
import com.food.model.OrderHistory;
import com.food.model.OrderItem;
import com.food.model.User;

@WebServlet("/checkOutServlet")
public class CheckOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve user inputs from request
        String address = request.getParameter("address");
        String paymentMode = request.getParameter("payment");

        // Get session and retrieve necessary attributes
//        HttpSession session = request.getSession();
        HttpSession session = request.getSession(true);

        User loggedin = (User) session.getAttribute("loggedin");
        Integer restaurantId = (Integer) session.getAttribute("restaurant_id");
        session.setAttribute("restaurant_id", restaurantId);

//        Integer userId = (Integer) session.getAttribute("user_id");
//        LinkedHashMap<Integer, CartItems> items = (LinkedHashMap<Integer, CartItems>) session.getAttribute("cartCreator");
        CartCreator cartCreator = (CartCreator) session.getAttribute("cartCreator");
        System.out.println("checkoutservletstrt");
        System.out.println(loggedin.getUserId());
        	Integer	userId=loggedin.getUserId();
        	String username= loggedin.getUsername();
        	String email= loggedin.getEmail();
      
        	System.out.println(restaurantId);
        	System.out.println(cartCreator);
        	System.out.println("checkoutservletend");
            if (userId == null || restaurantId == null || cartCreator == null) {
            // Handle the error case
            	System.out.println(userId);
            	System.out.println(restaurantId);
            	System.out.println(cartCreator);
            request.setAttribute("errorMessage", "User ID, Restaurant ID, or Cart Creator is missing. Please try again.");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
            requestDispatcher.forward(request, response);
            return;
        }

        LinkedHashMap<Integer, CartItems> items = cartCreator.getCartItems();
        double totalAmount = 0.0;

        Set<Entry<Integer, CartItems>> entrySet = items.entrySet();
        for (Entry<Integer, CartItems> entry : entrySet) {
            CartItems cartItem = entry.getValue();
            int quantity = cartItem.getQuantity();
            double price = cartItem.getPrice();
            totalAmount += quantity * price;
        }
        // Create and save the order
        OrderDAOImp orderDAOImp = new OrderDAOImp();
        Order order = new Order(userId, restaurantId, totalAmount, "Delivered", paymentMode);
        orderDAOImp.addOrder(order);
        System.out.println(order.getPaymentmethod());
        System.out.println(order.getOrderId());
        int orderId = orderDAOImp.getLastOrderId();// Implement this method to get the last order ID

        // Save order items
        if (items != null) {
            OrderItemDAOImp orderItemDAOImp = new OrderItemDAOImp();

            System.out.println("orderitemid"+orderId);
            for (Entry<Integer, CartItems> entry : items.entrySet()) {
                CartItems cartItem = entry.getValue();
                int menuId = cartItem.getItemId();
                int quantity = cartItem.getQuantity();
                float price = cartItem.getPrice();
                float totalPrice = quantity * price;
                
                OrderItem orderItem = new OrderItem(orderId, menuId, quantity,  totalPrice);
                orderItemDAOImp.addOrderItem(orderItem);
            }
        }

        // Save to order history                      new java.sql.Date(System.currentTimeMillis()),  uname,pwd,emil,addres
        OrderHistoryDAOImp orderHistorDAOImp = new OrderHistoryDAOImp();
        OrderHistory orderHistory = new OrderHistory(orderId, userId, username, email, address, "Delivered", totalAmount);
        orderHistorDAOImp.addOrderHistory(orderHistory);
        System.out.println("ordersuces");
       // Forward to the success page
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ordersuccess.jsp");
        requestDispatcher.include(request, response);
    }

//    private int getLastOrderId() {
//
//        // Implement this method to get the last inserted order ID
//        // This typically involves querying the database to get the last inserted ID
//        return 0; // Replace with actual implementation
//    }
}
