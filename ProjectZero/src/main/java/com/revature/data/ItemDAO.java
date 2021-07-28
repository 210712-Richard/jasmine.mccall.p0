
package com.revature.data;


	import java.io.Serializable;

	import java.util.ArrayList;
	import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.beans.User;
import com.revature.controllers.UserController;
import com.revature.beans.Item;



	public class ItemDAO implements Serializable {


		/**
		 * 
		 */
		private static Logger log = LogManager.getLogger(UserController.class);
		private static final long serialVersionUID = 1L;
		private static String filename = "items.dat";
		private static List<Item> item;
		
		static {
			DataSerializer2<Item> dsr = new DataSerializer2<Item>();
			item = dsr.readObjectsFromFile("items.dat");
			
			if(item == null) {
				item = new ArrayList<Item>();
				Item i = new Item("Standard Cash Envelopes", 3.00D);
				i.setQuantity(1);
				i.setItemID((int) item.size());
				item.add(i);
				log.info("adding new item");
			
				i = new Item("Mini Cash Envelopes", 2.50D);
				i.setQuantity(1);
				i.setItemID((int) item.size());
				item.add(i);
				log.info("adding new item");
				
				i = new Item("Cash Breakdown Card", 2.00D);
				i.getQuantity();
				i.setItemID((int) item.size());
				item.add(i);
				log.info("adding new item");

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
		
		public Item getItemByItemID(Integer itemID) {
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
		
		public Double cartTotal() {
			User u = new User();
			Item it = new Item();
			Double totalPrice = 0.0D;
			for(int i = 0; i < u.getCart().size(); i++){
				
				totalPrice = it.getPrice() * it.getQuantity();
			}
			
			return totalPrice;
		}
		
		public void writeToFile() {
			new DataSerializer2<Item>().writeObjectsToFile(item, filename);

		}


	}


