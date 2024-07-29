package com.food.model;
import java.sql.Date;
import java.sql.Timestamp;

public class OrderHistory{
    private int orderHistoryId;
    private int orderId;
    private int userId;
    private String userName;
    private String email;
    private String address;
    private String status;
    private double totalAmount;
    private Date orderDate;
    private Timestamp createdAt;
    
   public OrderHistory() {
	// TODO Auto-generated constructor stub
}
    
	public OrderHistory(int orderId, int userId, String userName, String email, String address, String status,
			double totalAmount) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.status = status;
		this.totalAmount = totalAmount;
	}



	public int getOrderHistoryId() {
		return orderHistoryId;
	}



	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}



	public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public Timestamp getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Timestamp timestamp) {
		this.createdAt = timestamp;
	}



	@Override
	public String toString() {
		return "OrderHistory [orderHistoryId=" + orderHistoryId + ", orderId=" + orderId + ", userId=" + userId
				+ ", userName=" + userName + ", email=" + email + ", address=" + address + ", status=" + status
				+ ", totalAmount=" + totalAmount + ", orderDate=" + orderDate + ", createdAt=" + createdAt + "]";
	}
    
    
}