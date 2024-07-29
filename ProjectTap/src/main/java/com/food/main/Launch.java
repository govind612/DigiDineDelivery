package com.food.main;

import java.util.List;

import com.food.DAOImp.RestaurantDAOImp;
import com.food.model.Restaurant;

public class Launch {
public static void main(String[] args) {
//	User u = new User("tim","tim@123","tim@gmail.com","BTM","customer");
//	UserDAOImp ui= new UserDAOImp();
//	ui.addUser(u);
	
//	Restaurant r= new Restaurant(1,"McD", "Fastfod", 30,"BTM" , 1,3.7 , true);
//	RestaurantDAOImp rd= new RestaurantDAOImp();
//	rd.addRestaurant(r);

	
//	Restaurant r = new Restaurant();
//	RestaurantDAOImp rd = new RestaurantDAOImp();
//	Restaurant restaurant=rd.getRestaurant(1);
//	System.out.println(restaurant);
	
//	Restaurant r= new Restaurant(1,"BK", "Fastfod", 30,"BTM" , 1,3.7 , true,null);
//	RestaurantDAOImp rd= new RestaurantDAOImp();
//	rd.updateRestaurant(r);

//	RestaurantDAOImp rd= new RestaurantDAOImp();
//
//	rd.deleteRestaurant(2);

	
	RestaurantDAOImp rd= new RestaurantDAOImp();
	List<Restaurant> l=rd.getAllRestaurant();
	for (Restaurant restaurant : l) {
		System.out.println(restaurant);
	}

}
}
