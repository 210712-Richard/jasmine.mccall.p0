package com.revature.services;

import java.time.LocalDate;

import com.revature.model.Cart;
import com.revature.model.User;
import com.revature.data.UserDAO;

public class UserServices {
	
	public UserDAO ud = new UserDAO();
	
	public User login(String name) {
		User u = ud.getUser(name);
		return u;
	}
	
	public void doCheckIn(User user) {
		user.setLastCheckIn(LocalDate.now());
		user.setInventory(user.getInventory());
		user.setCoupon(user.getCoupon());
	
		ud.writeToFile();
		
	}
	
	public void register(String username, String email) {
		User u = new User();
		u.setUsername(username);
		u.setEmail(email);
		u.setCoupon(10);
		ud.addUser(u);
		ud.writeToFile();
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