
package com.revature.data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Cart;


	public class CartDAO implements Serializable {


		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static String filename = "cart.dat";
		private static List<Cart> cart;
		
		static {
			DataSerializer3<Cart> dsr = new DataSerializer3<Cart>();
			cart = dsr.readObjectsFromFile("cart.dat");
			
			if(cart == null) {
				cart = new ArrayList<Cart>();
				dsr.writeObjectsToFile(cart, "cart.dat");
			}
		}
		public void addCart(Cart i) {
			cart.add(i);

			
		}
		public List<Cart> getCart(){
			return cart;
		}
		
//		public Item getItem(String name, Float price) {
//			
//			for(Item item : item) {
//				if(((ItemDAO) item).getItem().equals(name)) {
//					return item;
//				}
//			
//			
//			return null;
//		}
		
		
		public void writeToFile() {
			new DataSerializer3<Cart>().writeObjectsToFile(cart, filename);
		}

	}
