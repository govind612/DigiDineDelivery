package com.food.model;

public class OrderItem {
	private int orderItemId;
	private int orderId;
	private int menuId;
	private int quantity;
	private double itemTotal;
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public OrderItem( int orderId, int menuId, int quantity, double itemTotal) {
		super();
//		this.orderItemId = orderitemId;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}

	public int getOrderitemId() {
		return orderItemId;
	}

	public void setOrderitemId(int orderitemId) {
		this.orderItemId = orderitemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}
	
}
