
package com.revature.data;


	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.List;

import com.revature.beans.Item;



	public class ItemDAO implements Serializable {


		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static String filename = "items.dat";
		private static List<Item> item;
		
		static {
			DataSerializer2<Item> dsr = new DataSerializer2<Item>();
			item = dsr.readObjectsFromFile("items.dat");
			
			if(item == null) {
				item = new ArrayList<Item>();
				item.add(new Item("Standard Cash Envelopes", 3.00F, 1));
				item.add(new Item("Mini Cash Envelopes", 2.50F, 2));
				item.add(new Item("Cash Breakdown", 2.00F, 3));
				dsr.writeObjectsToFile(item, "items.dat");
			}
		}
		public void addItem(Item items) {
			items.setItemID((int)item.size());
			item.add(items);

			
		}
		public List<Item> getItem(){
			return item;
		}
		
		public Item getItem(Integer itemID) {
			return item.stream()
					.filter((i) -> i.getItemID().equals(itemID))
					.findFirst()
					.orElse(null);
		}
		public Item getItemByName(String name) {
			return item.stream()
					.filter((i) -> i.getName().equals(name))
					.findFirst()
					.orElse(null);
		}
//		public List<Cart> getCart(){
//		return cart;
//	}
		
		public void writeToFile() {
			new DataSerializer2<Item>().writeObjectsToFile(item, filename);
		}


	}


