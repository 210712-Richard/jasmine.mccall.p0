package com.revature.beans;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username; 
	private String email;
	private int coupon;
	private UserType type;
	private LocalDate lastCheckIn;
	private List<Item> cart;
	
	public User() {
		super();
		this.type = UserType.CUSTOMER;
		this.lastCheckIn = LocalDate.of(2021,1,1);
		this.cart = new ArrayList<Item>();
		
	}
	public User(String username, String email, int coupon) {
		this();
		this.username = username;
		this.email = email;
		this.coupon = coupon;
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
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public LocalDate getLastCheckIn() {
		return lastCheckIn;
	}
	public void setLastCheckIn(LocalDate lastCheckIn) {
		this.lastCheckIn = lastCheckIn;
	}
	public List<Item> getCart() {
		if(cart == null) {
			cart = new ArrayList<Item>();
			
		
		}
		return cart;
	}
	public void setCart(List<Item> cart) {
		this.cart = cart;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + coupon;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (coupon != other.coupon)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
	
		return "User [username=" + username + ", email=" + email + ", coupon=" + coupon + ", type=" + type
				+ ", lastCheckIn=" + lastCheckIn + ", cart=" + cart + "]";
	}
	}
	