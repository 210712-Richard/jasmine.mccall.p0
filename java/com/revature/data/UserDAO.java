package com.revature.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.User;
import com.revature.model.UserType;

public class UserDAO {

	private static String filename = "user.dat";
	private static List<User> users;
	
	static {
		DataSerializer<User> ds = new DataSerializer<User>();
		users = ds.readObjectsFromFile(filename);
		
		if(users == null) {
			users = new ArrayList<User>();
			User t = new User("tim", "tim@yahoo.com");
			User u = new User("jasmine", "jasmine@jasmineswallet.com");
			u.setType(UserType.SELLER);
			users.add(t);
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
