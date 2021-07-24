package com.revature.services;

import java.awt.ItemSelectable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.data.ItemDAO;
import com.revature.data.UserDAO;
//import com.revature.data.CartDAO;

public class UserServices {
	
	public UserDAO ud = new UserDAO();
	public ItemDAO id = new ItemDAO();
	//public CartDAO cd = new CartDAO();
	
	public User login(String name) {
		User u = ud.getUser(name);
		return u;
	}
	
	public void doCheckIn(User user) {
		user.setLastCheckIn(LocalDate.now());
		user.setCart(user.getCart());
		user.setCoupon(user.getCoupon());
		ud.writeToFile();
		
	}
	
	public User register(String username, String email) {
		User u = new User();
		u.setUsername(username);
		u.setEmail(email);
		u.setCoupon(10);
		ud.addUser(u);
		ud.writeToFile();
		return u;
	}
	
	public void newItem(String name, Float price, int itemID) {
		Item i = new Item(name, price, itemID);
		i.setName(name);
		i.setPrice(0F);
		i.setItemID(itemID);
		id.addItem(i);
		id.writeToFile();
		
	}
//	public Item addToCart(Item item){
//		//Cart c = new Cart();
//		//c.addItem(name, price, itemID);
//		//cd.addCart(c);
//		id.addItem(item);
//		id.writeToFile();
//		return item;
//		}
	
	public Item addToCart(User user){
		//Item it = null;
		//.UserServices<Item> cart = id.getItem();
		//Cart c = new Cart();
		//c.addItem(name, price, itemID);
		//cd.addCart(c);
		//id.getItem();
		//id.addItem(items);
		//id.getItem();
		// List<Product> cartItems = new ArrayList<Product>()cartItems.add(item);
		//Item items = null;
		//List <Item> cart = new ArrayList<Item> ();
		Item item = id.getItem(null);
	
        //item.setItemID((int) user.getCart().size());
		user.getCart().add(item);
		id.writeToFile();
		return item;
	}
	public boolean hasCheckedIn(User user) {
		if(LocalDate.now().isAfter(user.getLastCheckIn())) {
			return false;
		}
		return true;
	}
	public boolean checkAvailability(String newName) {
		return ud.getUser()
				.stream()
				.noneMatch((u)->u.getUsername().equals(newName));

}
}