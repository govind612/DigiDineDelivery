package com.food.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderDAO;
import com.food.model.Order;

public class OrderDAOImp implements OrderDAO{
	
	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String UserName="root";
	String password="root";
	Connection con=null;
	
	
	
	public OrderDAOImp() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		con=	DriverManager.getConnection(url, UserName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
//	@Override
//	public void addOrder(Order order) {
//		PreparedStatement stmt=null;
//		String INSERTQUERY=" INSERT INTO order(total_amount,status,payment_method) VALUES(?,?,?)";
//		try {
//			 stmt=con.prepareStatement(INSERTQUERY);
//			stmt.setDouble(1, order.getTotalAmount());
//			stmt.setString(2,order.getStatus());
//			stmt.setString(3, order.getPaymentmethod());
//			
//			stmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
    public void addOrder(Order order) {
        String INSERTQUERY = "INSERT INTO `order` (user_id, restaurant_id, order_date, total_amount, status, payment_method) VALUES (?, ?, NOW(), ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(INSERTQUERY)) {
            stmt.setInt(1, order.getUserId());
            stmt.setInt(2, order.getRestaurantId());
            stmt.setDouble(3, order.getTotalAmount());
            stmt.setString(4, order.getStatus());
            stmt.setString(5, order.getPaymentmethod());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	@Override
	public Order getOrder(int orderId) {
		String SELECT=" Select * from order where order_id=?";
		PreparedStatement stmt= null;
		ResultSet res;
		Order order = null;
		try {
			stmt= con.prepareStatement(SELECT);
			
			stmt.setInt(1, orderId);
			res=stmt.executeQuery();
			while(res.next())
			{
				order= extarctFromResultSet(res);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}

	private Order extarctFromResultSet(ResultSet res) throws SQLException {

		Order order = new Order();
		order.setOrderId(res.getInt("order_id"));
		order.setUserId(res.getInt("user_id"));
		order.setRestaurantId(res.getInt("restaurant_id"));
		order.setOrderDate(res.getDate("order_date"));
		order.setTotalAmount(res.getDouble("total_amount"));
		order.setStatus(res.getString("status"));
		order.setPaymentmethod(res.getString("payment_method"));
		
		
		
		
		
		
		return order;
	}
	@Override
	public void updateOrder(Order order) {
		String UPDATEQUERY="update order set totalAmount=?,status=?,payment_method=? where order_id=?";
		PreparedStatement stmt = null ;
		try {
			stmt.setDouble(1, order.getTotalAmount());
			stmt.setString(2, order.getStatus());
			stmt.setString(3, order.getPaymentmethod());
			stmt.setInt(4, order.getOrderId());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void deleteOrder(int orderId) {
String DELETEQUERY="delete from order where order_id=?";
PreparedStatement stmt = null;

		try {
			stmt=con.prepareStatement(DELETEQUERY);
			
			stmt.setInt(1, orderId);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Override
//	public List<Order> getAllOrderByUser(int userId) {
//		String sql="select * from order";
//		Statement stmt=null;
//		List<Order>od=new ArrayList<Order>();
//		ResultSet res;
//		Order order;
//		try{
//			res=stmt.executeQuery(sql);
//			while(res.next())
//			{
//				order=extarctFromResultSet(res);
//				od.add(order);
//			}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return od;
//	}
//	
	
    @Override
    public List<Order> getAllOrderByUser(int userId) {
        String sql = "SELECT * FROM `order` WHERE user_id=?";
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                orders.add(extarctFromResultSet(res));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
	public int getLastOrderId() {
	 
		int orderId = -1;
		    String query = "SELECT LAST_INSERT_ID()";

//		    try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		        try {
		        	Statement stmt = con.createStatement();
		         ResultSet rs = stmt.executeQuery(query);

		        if (rs.next()) {
		            orderId = rs.getInt(1);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return orderId;
		}


}
