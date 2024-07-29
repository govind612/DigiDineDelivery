package com.food.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.UserDAO;
import com.food.model.User;

public class UserDAOImp implements UserDAO{
	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String UserName="root";
	String password="root";
	Connection con=null;
	
	public UserDAOImp() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection(url, UserName, password);
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	
	}
	
	
	@Override
	public int addUser(User user) {
		String InsertQuery="INSERT INTO `user` (`username`,`password`,`email`,`address`,`role`) VALUES(?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(InsertQuery);
			stmt.setString(1,user.getUsername());
			stmt.setString(2,user.getPassword());
			stmt.setString(3,user.getEmail());
			stmt.setString(4,user.getAddress());
			stmt.setString(5,user.getRole());
			
			return stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public User getUser(String email ,String password) {
		String query="SELECT * FROM user WHERE email=?";
		User user =null;

		try {
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, email);
			ResultSet	res=stmt.executeQuery();

			if(res.next()) {
				user=extractUserFormResultSet(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



			return user;
	}

	private User extractUserFormResultSet(ResultSet res) throws SQLException {
		
			User user=new User();
			
			
			user.setUserId(res.getInt("user_id"));
			user.setUsername(res.getString("username"));
			user.setPassword(res.getString("password"));
			user.setEmail(res.getString("email"));
			user.setAddress(res.getString("address"));
			user.setRole(res.getString("role"));

		return user;
	}


	@Override
	public void updateUser(User user) {
String query="UPDATE user SET username=?,password=?,email=?,address=?,role=? WHERE user_id=?";
		
		try {
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getRole());
			stmt.setInt(6, user.getUserId());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteUser(int userId) {
	String query="DELETE FROM user WHERE user_id=?";
		
		try {
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setInt(1, userId);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUser() {
	String query="SELECT * FROM user";
		
		List<User> al=new ArrayList();
		try {
			PreparedStatement stmt=con.prepareStatement(query);
			ResultSet res=stmt.executeQuery();
			
			while(res.next()) {
				try {
					al.add(extractUserFormResultSet(res));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return al;
	}




}