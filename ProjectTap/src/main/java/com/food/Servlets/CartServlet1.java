package com.food.Servlets;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAOImp.MenuDAOImp;
import com.food.model.CartCreator;
import com.food.model.CartItems;
import com.food.model.Menu;
import com.food.model.User;

@WebServlet("/cartServlet")
public class CartServlet1 extends HttpServlet {
    private CartCreator cart;
    private LinkedHashMap<Integer, CartItems> items;
    private int menuId;
    private int quantity;

    @Override		
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("ac");
        HttpSession session = request.getSession(true);

        User loggedin = (User) session.getAttribute("loggedin");
        Integer restaurantId = (Integer) session.getAttribute("restaurant_id");
//        Integer userId = (Integer) session.getAttribute("user_id");

        // Check if user is logged in
        if (loggedin == null ) {
            response.sendRedirect("login.jsp"); // Redirect to login if not logged in
            return;
        }

        cart = (CartCreator) session.getAttribute("cartCreator");

        if (cart == null) {
            cart = new CartCreator();
            session.setAttribute("cartCreator", cart);
        }

        items = cart.getCartItems();

        System.out.println("cartservletservice start");
        System.out.println(loggedin);
        System.out.println(loggedin.getUserId());
        System.out.println(restaurantId);
        System.out.println(cart);
        System.out.println("cartservletservice");

        if ("add".equals(action)) {
            add(request, cart);
        } else if ("remove".equals(action)) {
            remove(request);
        } else if ("update".equals(action)) {
            update(cart, request);
            System.out.println("cartservletupdate");
            System.out.println(loggedin);
            System.out.println(loggedin.getUserId());
            System.out.println(restaurantId);
            System.out.println(cart);
            System.out.println("cartservletupdend");
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
        requestDispatcher.include(request, response);
    }

    public void add(HttpServletRequest req, CartCreator cart) {
        menuId = Integer.parseInt(req.getParameter("menuId"));
        quantity = Integer.parseInt(req.getParameter("quantity"));
        MenuDAOImp menuDAOImp = new MenuDAOImp();
        Menu menuDetails = menuDAOImp.getMenu(menuId);
        req.setAttribute("menu", menuDetails);

        int itemId = menuDetails.getMenuId();
        int restaurantId = menuDetails.getRestaurantId();
        String itemName = menuDetails.getItemName();
        int price = (int) menuDetails.getPrice();
        CartItems cartItems = new CartItems(itemId, restaurantId, itemName, price, quantity);

        items = cart.addItem(cartItems);
        HttpSession session = req.getSession();
        session.setAttribute("item", cart);
    }

    public void remove(HttpServletRequest req) {
        int menuId = Integer.parseInt(req.getParameter("menuItemId"));
        items.remove(menuId);
    }

    public void update(CartCreator cart, HttpServletRequest req) {
        int menuId = Integer.parseInt(req.getParameter("menuItemId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        if (items.containsKey(menuId)) {
            CartItems cartItemsObject = items.get(menuId);
            cartItemsObject.setQuantity(quantity);
        }
    }
}