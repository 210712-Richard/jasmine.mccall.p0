package com.revature.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataSerializer3<T> implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<T> readObjectsFromFile(String filename) {
		List<T> Cart = null;
		try(ObjectInputStream o = new ObjectInputStream(new FileInputStream(filename));){
			Cart = (ArrayList<T>) o.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Cart;
	}

	public void writeObjectsToFile(List<T> Cart, String filename) {
		try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename));){
			o.writeObject(Cart);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
