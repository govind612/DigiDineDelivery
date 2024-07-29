package com.food.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.MenuDAO;
import com.food.DAOImp.MenuDAOImp;
import com.food.model.Menu;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
     MenuDAO menuDAO;

    @Override
    public void init() throws ServletException {
        menuDAO = new MenuDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int restaurantId = Integer.parseInt(request.getParameter("restaurant_id"));
        HttpSession session = request.getSession(true);
        session.setAttribute("restaurant_id", restaurantId);
        List<Menu> menuList = menuDAO.getMenuByRestaurantId(restaurantId);
        request.setAttribute("menuList", menuList);
        System.out.println("menuservlet"+menuList);
        request.getRequestDispatcher("menu.jsp").include(request, response);
    }
}