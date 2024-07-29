package com.food.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.UserDAO;
import com.food.DAOImp.UserDAOImp;
import com.food.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	UserDAO userDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public void init() throws ServletException {
    	userDAO =new UserDAOImp();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username,password,cpassword,email,address,role;
		
		username= request.getParameter("username");
		email= request.getParameter("email");
		password= request.getParameter("password");
		cpassword= request.getParameter("cpassword");
		address= request.getParameter("address");
		role= request.getParameter("role");
		
		if(password.equals(cpassword))
		{
			int x=userDAO.addUser(new User(username,password,email,address,role));
			if(x!=0)
			{
				response.sendRedirect("login.jsp");
			}
			else
			{
				response.sendRedirect("failure.jsp");
			}
		}
		
		else {
			response.sendRedirect("passwordError.jsp");
		}
		


		
		
	}

}
