package com.food.DAOImp;
//package com.food.DAOImp;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.food.DAO.OrderHistoryDAO;
//import com.food.model.OrderHistory;
//
//public class OrderHistorDAOImp implements OrderHistoryDAO {
//
//	String url="jdbc:mysql://localhost:3306/online_food_delivery";
//	String UserName="root";
//	String password="root";
//	Connection con=null;
//	
//	public OrderHistorDAOImp() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		con=	DriverManager.getConnection(url, UserName, password);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
////	@Override
////	public void addOrderHistory(OrderHistory orderHistory) {
////		
////		String sql="INSERT INTO order_history(totalAmount,status) VALUES(?,?)";
////		try {
////			PreparedStatement stmt=con.prepareStatement(sql);
////			stmt.setDouble(1, orderHistory.getTotalAmount());
////			stmt.setString(2,orderHistory.getStatus());
////			
////			stmt.executeUpdate();
////			
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		
////		
////	} 
//		@Override
//	    public void addOrderHistory(OrderHistory orderHistory) {
//	        String sql = "INSERT INTO order_history (user_id, order_id, orderDate, totalAmount, status) VALUES (?, ?, NOW(), ?, ?)";
//	        try (PreparedStatement stmt = con.prepareStatement(sql)) {
//	            stmt.setInt(1, orderHistory.getUserId());
//	            stmt.setInt(2, orderHistory.getOrderId());
//	            stmt.setDouble(3, orderHistory.getTotalAmount());
//	            stmt.setString(4, orderHistory.getStatus());
//	            stmt.executeUpdate();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	    }
//
//	@Override
//	public OrderHistory getOrderHistory(int orderHistoryId) {
//		String sql="SELECT * FROM order_history WHERE order_history_id=?";
//		OrderHistory orderHistory=null;
//		try {
//			PreparedStatement stmt=con.prepareStatement(sql);
//			stmt.setInt(1, orderHistoryId);
//			ResultSet res=stmt.executeQuery();
//			
//			if(res.next())
//			{
//				orderHistory=extractOrderHistoryFromResultSet(res);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return orderHistory;//		return null;
//	}
//
//	private OrderHistory extractOrderHistoryFromResultSet(ResultSet res) throws SQLException {
//		OrderHistory orderHistory=new OrderHistory();
//		orderHistory.setOrderHistoryId(res.getInt("order_history_id"));
//		orderHistory.setOrderId(res.getInt("order_id"));
//		orderHistory.setUserId(res.getInt("user_id"));
//		orderHistory.setOrderDate(res.getDate("orderDate"));
//		orderHistory.setTotalAmount(res.getDouble("totalAmount"));
//		orderHistory.setStatus(res.getString("status"));
//		return orderHistory;//		return null;
//	}
//	@Override
//	public void updateOrderHistory(OrderHistory orderHistory) {
//		String sql="UPDATE order_history SET totalAmount=?,status=? WHERE order_history_id=? ";
//		try {
//			PreparedStatement stmt=con.prepareStatement(sql);
//			stmt.setDouble(1, orderHistory.getTotalAmount());
//			stmt.setString(2, orderHistory.getStatus());
//			stmt.setInt(3, orderHistory.getOrderHistoryId());
//			
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//	}
//
//	@Override
//	public void deleteOrderHistory(int orderHistoryId) {
//		String sql="DELETE FROM order_history WHERE order_history_id=?";
//		try {
//			PreparedStatement stmt=con.prepareStatement(sql);
//			stmt.setInt(1, orderHistoryId);
//			
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		
//	}
//
////	@Override
////	public List<OrderHistory> getOrderHistoriesByUser(int userId) {
////
////		Statement stmt=null;
////		ResultSet res;
////		List<OrderHistory> al=new ArrayList();
////		String sql="Select * from order_history";
////		try {
////			stmt=con.createStatement();
////			res=stmt.executeQuery(sql);
////			
////			while(res.next())
////			{
////				OrderHistory orderHistory = extractOrderHistoryFromResultSet(res);
////				al.add(orderHistory);	
////			}
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		return al;//		return null;
////	}
//    @Override
//    public List<OrderHistory> getOrderHistoriesByUser(int userId) {
//        String sql = "SELECT * FROM order_history WHERE user_id=?";
//        List<OrderHistory> orderHistories = new ArrayList<>();
//        try (PreparedStatement stmt = con.prepareStatement(sql)) {
//            stmt.setInt(1, userId);
//            ResultSet res = stmt.executeQuery();
//            while (res.next()) {
//                orderHistories.add(extractOrderHistoryFromResultSet(res));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return orderHistories;
//    }
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderHistoryDAO;
import com.food.model.OrderHistory;

public class OrderHistoryDAOImp implements OrderHistoryDAO {

    String url = "jdbc:mysql://localhost:3306/online_food_delivery";
    String userName = "root";
    String password = "root";
    Connection con = null;

    public OrderHistoryDAOImp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addOrderHistory(OrderHistory orderHistory) {
        String sql = "INSERT INTO order_history (order_id, user_id, user_name, email, address, status, total_amount, order_date) VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, orderHistory.getOrderId());
            stmt.setInt(2, orderHistory.getUserId());
            stmt.setString(3, orderHistory.getUserName());
            stmt.setString(4, orderHistory.getEmail());
            stmt.setString(5, orderHistory.getAddress());
            stmt.setString(6, orderHistory.getStatus());
            stmt.setDouble(7, orderHistory.getTotalAmount());
//            stmt.setDate(8, new java.sql.Date(orderHistory.getOrderDate().getTime()));
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderHistory getOrderHistory(int orderHistoryId) {
        String sql = "SELECT * FROM order_history WHERE order_history_id=?";
        OrderHistory orderHistory = null;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, orderHistoryId);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                orderHistory = extractOrderHistoryFromResultSet(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

    private OrderHistory extractOrderHistoryFromResultSet(ResultSet res) throws SQLException {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderHistoryId(res.getInt("order_history_id"));
        orderHistory.setOrderId(res.getInt("order_id"));
        orderHistory.setUserId(res.getInt("user_id"));
        orderHistory.setUserName(res.getString("user_name"));
        orderHistory.setEmail(res.getString("email"));
        orderHistory.setAddress(res.getString("address"));
        orderHistory.setStatus(res.getString("status"));
        orderHistory.setTotalAmount(res.getDouble("total_amount"));
        orderHistory.setOrderDate(res.getDate("order_date"));
        orderHistory.setCreatedAt(res.getTimestamp("created_at"));
        return orderHistory;
    }

    @Override
    public void updateOrderHistory(OrderHistory orderHistory) {
        String sql = "UPDATE order_history SET user_id=?, user_name=?, email=?, address=?, status=?, total_amount=?, order_date=?,created_at=NOW() WHERE order_history_id=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, orderHistory.getUserId());
            stmt.setString(2, orderHistory.getUserName());
            stmt.setString(3, orderHistory.getEmail());
            stmt.setString(4, orderHistory.getAddress());
            stmt.setString(5, orderHistory.getStatus());
            stmt.setDouble(6, orderHistory.getTotalAmount());
            stmt.setDate(7, new java.sql.Date(orderHistory.getOrderDate().getTime()));
            stmt.setInt(8, orderHistory.getOrderHistoryId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderHistory(int orderHistoryId) {
        String sql = "DELETE FROM order_history WHERE order_history_id=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, orderHistoryId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderHistory> getOrderHistoriesByUser(int userId) {
        String sql = "SELECT * FROM order_history WHERE user_id=?";
        List<OrderHistory> orderHistories = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                orderHistories.add(extractOrderHistoryFromResultSet(res));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistories;
    }
}
