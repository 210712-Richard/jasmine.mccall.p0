//package com.revature.beans;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Cart implements Serializable {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private List<Item> itemsInCart = new ArrayList<>();
//	
//	public void addItem(Item item) {
//		this.itemsInCart.add(item);
//	}
//	
//	public int totalItems () {
//		int total = 0;
//		for (Item items: itemsInCart) {
//			total += items.getQuantity();
//		}
//		return total;
//	}
//
//	public void addToCart(String name, float price, int quantity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void addItem(String name, float price, int quantity) {
//		// TODO Auto-generated method stub
//		
//	}
//}
