//package com.food.Servlets;
//
//import java.io.IOException;
//import java.util.LinkedHashMap;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import com.food.model.CartItems;
//import com.food.model.Menu;
//import com.food.DAOImp.MenuDAOImp;
//import com.food.model.CartCreator;
//
//@WebServlet("/")
//public class CartServlet extends HttpServlet {
//    public CartCreator cart;
//    LinkedHashMap<Integer, CartItems> items;
//    int menuId;
//    int quantity;
//
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Object action = request.getParameter("ac");
////        HttpSession session = req.getSession();
//		HttpSession session= request.getSession(true);
//    	session.getAttribute("loggedin", loggedin);
//        Integer restaurantId = (Integer) session.getAttribute("restaurant_id");
//        Integer userId = (Integer) session.getAttribute("user_id");
//        cart = (CartCreator) session.getAttribute("cartCreator");
//       	System.out.println("cartservletservicestrt");         	System.out.println(loggedin);
//System.out.println(userId);
//    	System.out.println(restaurantId);
//    	System.out.println(cart);
//    	System.out.println("cartservletservice");
//        if (cart == null) {
//            cart = new CartCreator();
//            session.setAttribute("cartCreator", cart);
//            
//        }
//
//        if ("add".equals(action)) {
//            add(request, cart);    
//        } else if ("remove".equals(action)) {
//            remove(request);
//        } else if ("update".equals(action)) {
//            update(cart, request);
//           System.out.println("cartservletupdate");
//       	System.out.println(loggedin);
//          	System.out.println(userId);
//        	System.out.println(restaurantId);
//        	System.out.println(cart);System.out.println("cartservletupdend");
//          
//        }
//
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
//        requestDispatcher.forward(request, response);
//    }
//
//    public void add(HttpServletRequest req, CartCreator cart) {
//        menuId = Integer.parseInt(req.getParameter("menuId"));
//        quantity = Integer.parseInt(req.getParameter("quantity"));
//        MenuDAOImp menuDAOImp = new MenuDAOImp();
//        Menu menuDetails = menuDAOImp.getMenu(menuId);
//        req.setAttribute("menu", menuDetails);
//
//        int itemId = menuDetails.getMenuId();
//        int restaurantId = menuDetails.getRestaurantId();
//        String itemName = menuDetails.getItemName();
//        int price = (int) menuDetails.getPrice();
//        CartItems cartItems = new CartItems(itemId, restaurantId, itemName, price, quantity);
//
//        items = cart.addItem(cartItems);
//        HttpSession session = req.getSession();
//        session.setAttribute("item", cart);
//    }
//
//    public void remove(HttpServletRequest req) {
//        int menuId = Integer.parseInt(req.getParameter("menuItemId"));
//        items.remove(menuId);
//    } 
//    
//   public void update(CartCreator cart, HttpServletRequest req) {
//
//		int menuId = Integer.parseInt(req.getParameter("menuItemId"));
//		int quantity = Integer.parseInt(req.getParameter("quantity"));
////		System.out.println(quantity);
//			if(items.containsKey(menuId))
//			{
//				CartItems cartItemsObject = items.get(menuId);
//				cartItemsObject.setQuantity(quantity);
//			}
//    }
//}
