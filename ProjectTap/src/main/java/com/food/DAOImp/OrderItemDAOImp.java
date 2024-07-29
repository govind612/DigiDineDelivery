package com.food.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderItemDAO;
import com.food.model.OrderItem;

public class OrderItemDAOImp implements OrderItemDAO{
	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String UserName="root";
	String password="root";
	Connection con=null;
	public OrderItemDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		con=	DriverManager.getConnection(url, UserName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	
	
//	@Override
//	public void addOrderItem(OrderItem orderItem) {
//			
//		String sql="INSERT INTO order_item(quantity,item_total) VALUES(?,?)";
//		try {
//			PreparedStatement stmt=con.prepareStatement(sql);
//			stmt.setInt(1,orderItem.getQuantity());
//			stmt.setDouble(2, orderItem.getItemTotal());
//			
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	   @Override
	    public void addOrderItem(OrderItem orderItem) {
	        String sql = "INSERT INTO order_item (order_id, menu_id, quantity, item_total) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement stmt = con.prepareStatement(sql)) {
	            stmt.setInt(1, orderItem.getOrderId());
	            stmt.setInt(2, orderItem.getMenuId());
	            stmt.setInt(3, orderItem.getQuantity());
	            stmt.setDouble(4, orderItem.getItemTotal());
	           int a= stmt.executeUpdate();
//	       System.out.println(a);
	        	} catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	@Override
	public OrderItem getOrderItem(int orderItemId) {
		String sql="SELECT * FROM order_item WHERE order_item_id=?";
		OrderItem orderItem=null;
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, orderItemId);
			ResultSet res=stmt.executeQuery();
			
			if(res.next())
			{
				orderItem=extractOrderItemFromResultSet(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItem;	}

	private OrderItem extractOrderItemFromResultSet(ResultSet res) throws SQLException {
		OrderItem orderItem=new OrderItem();
		orderItem.setOrderitemId(res.getInt(" order_item_id"));
		orderItem.setOrderId(res.getInt("order_id"));
		orderItem.setMenuId(res.getInt("menu_id"));
		orderItem.setQuantity(res.getInt("quantity"));
		orderItem.setItemTotal(res.getDouble("item_total"));
		return orderItem;//		return null;
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		String sql="UPDATE order_item SET quantity=?,item_total=? WHERE order_item_id=?";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, orderItem.getQuantity());
			stmt.setDouble(2, orderItem.getItemTotal());
			stmt.setInt(3, orderItem.getOrderitemId());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		String sql="DELETE FROM order_item WHERE order_item_id=?";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, orderItemId);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderItem> getAllOrderItemByUser(int userId) {
		{
			Statement stmt=null;
			ResultSet res;
			List<OrderItem> al=new ArrayList();
			String sql="Select * from order_item";
			try {
				stmt=con.createStatement();
				res=stmt.executeQuery(sql);
				
				while(res.next())
				{
					OrderItem orderItem = extractOrderItemFromResultSet(res);
					al.add(orderItem);	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return al;// TODO Auto-generated method stub
	//	return null;
	}
	}
}
