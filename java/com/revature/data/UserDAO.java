package com.revature.data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.beans.UserType;

public class UserDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String filename = "user.dat";
	private static List<User> users;
	
	static {
		DataSerializer<User> ds = new DataSerializer<User>();
		users = ds.readObjectsFromFile("user.dat");
		
		if(users == null) {
			users = new ArrayList<User>();
			users.add(new User("tim", "tim@yahoo.com", 10));
			User u = new User("jasmine", "jasmine@jasmineswallet.com", 0);
			u.setType(UserType.SELLER);
			users.add(u);
			ds.writeObjectsToFile(users, "user.dat");
		}
	}
	public void addUser(User u) {
		users.add(u);

		
	}
	public List<User> getUser(){
		return users;
	}
	
	public User getUser(String username) {
		
		for(User user : users) {
			if(user.getUsername().equals(username)) {
				return user;
			}
		}
		
		return null;
	}
	
	public void updateUser(User user) {

	}
	
	public void writeToFile() {
		new DataSerializer<User>().writeObjectsToFile(users, filename);
	}

}
