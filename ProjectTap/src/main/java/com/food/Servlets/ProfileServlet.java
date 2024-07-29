package com.food.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.model.User;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        HttpSession session = request.getSession();
	        User loggedInUser = (User) session.getAttribute("loggedin");
	        System.out.println("User retrieved from session: " + loggedInUser); 
	        if (loggedInUser != null) {
	            request.setAttribute("loggedin", loggedInUser);
	            request.getRequestDispatcher("profile.jsp").forward(request, response);
	        } else {
	            response.sendRedirect("login.jsp"); // Redirect to login if user is not logged in
	        }
	    }
	}
