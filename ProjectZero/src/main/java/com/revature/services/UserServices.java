package com.revature.services;


import java.time.LocalDate;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.data.ItemDAO;
import com.revature.data.UserDAO;


public class UserServices {
	private static final Logger log = LogManager.getLogger(UserServices.class);

	public UserDAO ud = new UserDAO();
	public ItemDAO id = new ItemDAO();

	
	public User login(String name) {
		User u = ud.getUser(name);
		return u;
	}
	
	public void doCheckIn(User user) {
		user.setLastCheckIn(LocalDate.now());
		user.setCart(user.getCart());
		user.setCoupon(user.getCoupon());
		ud.writeToFile();
		log.trace("Writing to file");
		
	}
	
	public User register(String username, String email) {
		User u = new User();
		u.setUsername(username);
		u.setEmail(email);
		u.setCoupon(10);
		ud.addUser(u);
		ud.writeToFile();
		log.trace("Writing to file");
		return u;
	}

	
	public Item newItem(String name, Double price) {
		Item i = new Item(name, price);
		i.setName(name);
		i.setPrice(price);
		id.addItem(i);
		id.writeToFile();
		log.trace("Writing to file");
		return i;
		
	}
	public Item addToCart(User user, Integer itemID){
        Item i = id.getItemByItemID(itemID);
        user.getCart().add((Item) i);
        
        id.writeToFile();
        log.trace("Writing to file");
        return (Item) i;
	}
	public Item removeFromCart(User user, Integer itemID){
        Item i = id.getItemByItemID(itemID);

        user.getCart().remove((Item) i);
        id.writeToFile();
        log.trace("Writing to file");
        return (Item) i;
	}
	public Double checkout(User user) {
		Double totalPrice =

	    id.cartTotal();
		id.writeToFile();
		log.trace("Writing to file");
		return totalPrice;
	}
	public void processOrders() {
		User user = new User();
		user.getCart().clear();
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