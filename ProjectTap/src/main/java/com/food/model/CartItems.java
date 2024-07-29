package com.food.model;

public class CartItems {
	private int itemId;
	private int restaurant_id;
	private String itemName;
	private int price;
	private int quantity;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
//	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartItems(int itemId, int restaurant_id, String itemName, int price, int quantity) {
		super();
		this.itemId = itemId;
		this.restaurant_id = restaurant_id;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartItems [itemId=" + itemId + ", restaurant_id=" + restaurant_id + ", itemName=" + itemName
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
