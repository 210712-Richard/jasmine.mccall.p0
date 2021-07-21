package com.revature.data;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.Serializable;
	import java.util.ArrayList;
	import java.util.List;

	public class DataSerializer2<T> implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public List<T> readObjectsFromFile(String filename) {
			List<T> Item = null;
			try(ObjectInputStream o = new ObjectInputStream(new FileInputStream(filename));){
				Item = (ArrayList<T>) o.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Item;
		}

		public void writeObjectsToFile(List<T> Item, String filename) {
			try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename));){
				o.writeObject(Item);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

}
