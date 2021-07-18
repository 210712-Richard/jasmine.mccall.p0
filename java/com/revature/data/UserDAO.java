package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;
import com.revature.model.UserType;

public class UserDAO {
	// DAO = Database Access Object
	// This is a class that is dedicated to accessing data from persistence.
	private static String filename = "users.dat";
	private static List<User> users;
	
	static {
		DataSerializer<User> ds = new DataSerializer<User>();
		users = ds.readObjectsFromFile(filename);
		
		// Helper for myself. If no users exist in the users.dat file (first startup) than I should create a few
		if(users == null) {
			users = new ArrayList<User>();
			User u = new User("jasmine", "jasmine@jasmineswallet.com");
			u.setType(UserType.SELLER);
			users.add(u);
			ds.writeObjectsToFile(users, filename);
		}
	}
	public void addUser(User u) {
		
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
