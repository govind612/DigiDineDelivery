package com.food.Servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.UserDAO;
import com.food.DAOImp.UserDAOImp;
import com.food.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		UserDAO userDAO;
	   @Override
	    public void init() throws ServletException {
	    	userDAO =new UserDAOImp();
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 		PrintWriter append = response.getWriter().append("Served at: ").append(request.getSession().getId());
		append.print(getServletName());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String	email= request.getParameter("email");
	String	password= request.getParameter("password");
	
	User loggedin =userDAO.getUser(email,password);
	
	if(loggedin.getPassword()!=null  && password.equals(loggedin.getPassword()))
	{
		HttpSession session= request.getSession(true);
	session.setAttribute("loggedin", loggedin);   
//	session.setAttribute("restaurant_id", restaurantId);

	 System.out.println("User stored in session: " + loggedin); response.sendRedirect("home");
	}
	else
	{
		response.sendRedirect("login.jsp");
	}
	}

}
