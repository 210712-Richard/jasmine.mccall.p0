package com.revature.model;

import java.time.LocalDate;
import java.util.List;

public class User {
	
	private String username; 
	private String email;
	private List <Cart> inventory;
	private UserType type;
	private LocalDate lastCheckIn;
	
	public User() {
		super();
		this.type = UserType.CUSTOMER;
		this.lastCheckIn = LocalDate.of(2021,1,1);
		
	}
	public User(String username, String email) {
		this();
		this.username = username;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Cart> getInventory() {
		return inventory;
	}

	public void setInventory(List<Cart> inventory) {
		this.inventory = inventory;
	}
	
	public LocalDate getLastCheckIn() {
		return lastCheckIn;
	}
	public void setLastCheckIn(LocalDate lastCheckIn) {
		this.lastCheckIn = lastCheckIn;
	}
	
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		result = prime * result + ((lastCheckIn == null) ? 0 : lastCheckIn.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		if (lastCheckIn == null) {
			if (other.lastCheckIn != null)
				return false;
		} else if (!lastCheckIn.equals(other.lastCheckIn))
			return false;
		if (type != other.type)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", inventory=" + inventory + ", type=" + type
				+ ", lastCheckIn=" + lastCheckIn + "]";
	}
	
	

}
