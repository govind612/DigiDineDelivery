package com.food.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.RestaurantDAO;
import com.food.model.Restaurant;

public class RestaurantDAOImp implements RestaurantDAO{
	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String UserName="root";
	String password="root";
	Connection con=null;
	public RestaurantDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url, UserName, password);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public void addRestaurant(Restaurant restaurant) {
		String INSERTQUERY="INSERT INTO restaurant(name,cuisinetype,deliverytime,address,adminuser_id,rating,isActive) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt=con.prepareStatement(INSERTQUERY);
			stmt.setString(1, restaurant.getname());
			stmt.setString(2, restaurant.getcuisinetype());
			stmt.setInt(3, restaurant.getDeliveryTime());
			stmt.setString(4, restaurant.getAddress());
			stmt.setInt(5, restaurant.getAdminUserId());
			stmt.setDouble(6, restaurant.getRating());
			stmt.setBoolean(7, restaurant.getIsActive());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		String SELECTQUERY="Select * from restaurant where restaurant_id=?";
		Restaurant restaurant=null;
		
		try {
			PreparedStatement stmt=con.prepareStatement(SELECTQUERY);
			stmt.setInt(1, restaurantId);
			ResultSet res= stmt.executeQuery();
			if(res.next())
			{
				restaurant = extractRestaurantFromResultSet(res);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restaurant;
	}

	private Restaurant extractRestaurantFromResultSet(ResultSet res) throws Exception {
		Restaurant restaurant =new Restaurant();
		restaurant.setRestaurantId(res.getInt("restaurant_id"));
		restaurant.setname(res.getString("name"));
		restaurant.setcuisinetype(res.getString("cuisinetype"));
		restaurant.setDeliveryTime(res.getInt("deliverytime"));
		restaurant.setAddress(res.getString("address"));
		restaurant.setAdminUserId(res.getInt("adminuser_id"));
		restaurant.setRating(res.getDouble("rating"));
		restaurant.setActive(res.getBoolean("isActive"));
		restaurant.setImgpath(res.getString("imgpath"));
		
		return restaurant;
	}
	@Override
	public void updateRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		String UPDATEQUERY="UPDATE restaurant set name=?,cuisinetype=?,deliverytime=?,address=?,adminuser_id=?,rating=?,isActive=? where restaurant_id=?";
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(UPDATEQUERY);
			stmt.setString(1, restaurant.getname());
			stmt.setString(2, restaurant.getcuisinetype());
			stmt.setInt(3, restaurant.getDeliveryTime());
			stmt.setString(4, restaurant.getAddress());
			stmt.setInt(5, restaurant.getAdminUserId());
			stmt.setDouble(6, restaurant.getRating());
			stmt.setBoolean(7, restaurant.getIsActive());
			stmt.setInt(8, restaurant.getRestaurantId());
			
			
			stmt.executeUpdate();
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

	@Override
	public void deleteRestaurant(int restaurantId) {

		String DELETEQUERY="DELETE from restaurant where restaurant_id=? ";
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(DELETEQUERY);

			stmt.setInt(1, restaurantId);
			
			stmt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		
		String SQL=" SELECT * FROM restaurant ";
		
		ArrayList<Restaurant> al= new ArrayList();
		Restaurant restaurant=null;
		
		try {
			PreparedStatement stmt= con.prepareStatement(SQL);
			
			ResultSet res = stmt.executeQuery();
			
			while (res.next()) {
				restaurant= extractRestaurantFromResultSet(res);
				al.add(restaurant);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	
	
	

}
