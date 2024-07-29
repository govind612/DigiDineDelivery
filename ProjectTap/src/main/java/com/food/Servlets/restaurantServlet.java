package com.food.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.RestaurantDAO;
import com.food.DAOImp.RestaurantDAOImp;
import com.food.model.Restaurant;

@WebServlet("/restaurant")
public class restaurantServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		RestaurantDAOImpl restaurantDAOImpl = new RestaurantDAOImpl();
		RestaurantDAO r= new RestaurantDAOImp();
		List<Restaurant> list = r.getAllRestaurant();
		System.out.println("restaurant list found"+list);
		HttpSession session = req.getSession();
		session.setAttribute("restaurantsLists", list);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("restaurant.jsp");
		requestDispatcher.include(req, resp);
	}
}