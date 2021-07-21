
package com.revature.data;


	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.List;

import com.revature.beans.Item;
import com.revature.data.DataSerializer2;


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
				item.add(new Item("Standard Cash Envelopes", 3.00F));
				item.add(new Item("Mini Cash Envelopes", 2.50F));
				item.add(new Item("Cash Breakdown", 2.00F));
				dsr.writeObjectsToFile(item, "items.dat");
			}
		}
		public void addItem(Item i) {
			item.add(i);

			
		}
		public List<Item> getItem(){
			return item;
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
			new DataSerializer2<Item>().writeObjectsToFile(item, filename);
		}

	}


