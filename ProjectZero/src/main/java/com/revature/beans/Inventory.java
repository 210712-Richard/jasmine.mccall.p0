package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Item> item = new ArrayList<Item>();
	
	public Inventory () {
		this.itemsInShop();
	}
	
	public void itemsInShop() {
		String[] itemName = {"Standard Cash Envelopes", "Mini Cash Envelopes", "Cash Breakdown Card"};
		Float [] itemPrice = {3.00f, 2.50f, 2.00f};
		
		for (int i = 0; i < itemName.length; i++) {
			this.item.add(new Item(itemName[i], itemPrice[i]));
		}		
	}

	  public List<Item> getItem() {
		return item;
	}
	  
}
