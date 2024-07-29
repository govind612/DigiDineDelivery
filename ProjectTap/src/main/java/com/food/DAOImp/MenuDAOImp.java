package com.food.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.MenuDAO;
import com.food.model.Menu;


public class MenuDAOImp implements MenuDAO {
	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String UserName="root";
	String password="root";
	Connection con=null;
	
	public MenuDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url, UserName, password);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public void addMenu(Menu menu) {
	
//		String INSERTQUERY="Insert into `menu`(`restaurant_id`,`itemname`,`description`,`price`,`isavailable`,`imgpath`) values(?,?,?,?,?,?) ";
//		 try {
//			PreparedStatement stmt= con.prepareStatement(INSERTQUERY);
//			stmt.setInt(1, menu.getMenuId());
//			stmt.setInt(1, menu.getRestaurantId());
//			stmt.setString(2, menu.getItemName());
//			stmt.setString(3, menu.getDescription());
//			stmt.setDouble(4, menu.getPrice());
//			stmt.setBoolean(5, menu.isAvailable());
//			stmt.setString(6, menu.getImgpath());
//			stmt.executeUpdate();
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		String sql="INSERT INTO menu(itemName,description,price,isAvailable) VALUES(?,?,?,?)";
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, menu.getItemName());
			pstmt.setString(2, menu.getDescription());
			pstmt.setDouble(3, menu.getPrice());
			pstmt.setBoolean(4, menu.isAvailable());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
	}
	@Override
	public Menu getMenu(int menuId) {
		String SELECTQUERY="Select * from menu where menu_id=?";
Menu menu=null;

		try {
			PreparedStatement stmt= con.prepareStatement(SELECTQUERY);
			stmt.setInt(1, menuId);
			ResultSet res= stmt.executeQuery();
			if(res.next())
			{
				menu = extractMenuFromResultSet(res);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menu;
	}
	private Menu extractMenuFromResultSet(ResultSet res) throws SQLException {
		Menu menu= new Menu();
		
		menu.setMenuId(res.getInt("menu_id"));
		menu.setRestaurantId(res.getInt("restaurant_id"));
		menu.setItemName(res.getString("itemname"));
		menu.setDescription(res.getString("description"));
		menu.setPrice(res.getDouble("price"));
		menu.setAvailable(res.getBoolean("isavailable"));
		
		
		
		
		
		return menu;
	}

	@Override
	public void updateMenu(Menu menu) {
//	String UPATEQUERY="Update menu set restaurant_id=? , itemname=?,description=?,price=? ,isavailable=? where menu_id=?"
//				
//				;
//		PreparedStatement stmt;
//		
//		try {
//			stmt= con.prepareStatement(UPATEQUERY);
//			
//			stmt.setInt(1, menu.getRestaurantId());
//			stmt.setString(2, menu.getItemName());
//			stmt.setString(3, menu.getDescription());
//			stmt.setDouble(4, menu.getPrice());
//			stmt.setInt(6, menu.getMenuId());
//			stmt.setBoolean(5, menu.isAvailable());
//			
//			
//			stmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}
		String sql="UPDATE menu SET itemName=?,description=?,price=?,isAvailable=? WHERE menuId=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, menu.getItemName());
			pstmt.setString(2, menu.getDescription());
			pstmt.setDouble(3, menu.getPrice());
			pstmt.setBoolean(4, menu.isAvailable());
			pstmt.setInt(5, menu.getMenuId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteMenu(int menuId) {
	String DELETEQUERY="DELETE from menu where menu_id=? ";
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(DELETEQUERY);

			stmt.setInt(1, menuId);
			
			stmt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	@Override
	public List<Menu> getAllMenuByRestaurant(Menu menu) {
		java.sql.Statement stmt=null;
		ResultSet res;
		List<Menu> al=new ArrayList<Menu>();
		String sql="Select * from menu";
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(sql);
			
			while(res.next())
			{
				menu = extractMenuFromResultSet(res);
				al.add(menu);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;//return al;
	}
	@Override
	public List<Menu> getMenuByRestaurantId(int restaurantId) {
		// TODO Auto-generated method stub
		String SELECTQUERY="Select * from menu where restaurant_id=?";
		Menu menu=null;
		List<Menu> al=new ArrayList<Menu>();

				try {
					PreparedStatement stmt= con.prepareStatement(SELECTQUERY);
					stmt.setInt(1, restaurantId );
					ResultSet res= stmt.executeQuery();
					while(res.next())
					{
						menu = extractMenuFromResultSet(res);
						al.add(menu);	

					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
		return al;	//null;
	}
	
}
