package com.food.model;

import java.util.LinkedHashMap;

public class CartCreator {
    private LinkedHashMap<Integer, CartItems> cartItems;

    public CartCreator() {
        this.cartItems = new LinkedHashMap<>();
    }

    public LinkedHashMap<Integer, CartItems> addItem(CartItems cartItem) {
        if (cartItems.containsKey(cartItem.getItemId())) {
            CartItems existingCartItem = cartItems.get(cartItem.getItemId());
            int currentQuantity = existingCartItem.getQuantity();
            existingCartItem.setQuantity(currentQuantity +  cartItem.getQuantity()); 
        } else {
            cartItem.setQuantity(1);
            cartItems.put(cartItem.getItemId(), cartItem);
        }
        return cartItems;
    }

    public void remove(int menuId) {
        if (cartItems.containsKey(menuId)) {
            cartItems.remove(menuId);
        }
    }

    public void update(int menuId, int quantity) {
        if (cartItems.containsKey(menuId)) {
            CartItems cartItemsObject = cartItems.get(menuId);
            cartItemsObject.setQuantity(quantity);
            System.out.println("adsfgvxh");
        }
    }

    public LinkedHashMap<Integer, CartItems> getCartItems() {
        return cartItems;
    }

	@Override
	public String toString() {
		return "CartCreator [cartItems=" + cartItems + "]";
	}
}