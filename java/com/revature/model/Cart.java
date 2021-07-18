package com.revature.model;
import com.revature.model.*;
import java.text.NumberFormat;

public class Cart<T> {


   private Item[] array;
   private int itemCount;  
   private int totalPrice;
   public static final Integer INITIAL_CAPACITY = 25;
   private int capacity;
   
   public Cart() {
		this(Cart.INITIAL_CAPACITY);
	}

	public Cart (int capacity) {
		array = new Item[capacity];
		this.capacity = capacity;
		this.itemCount = 0;
   }
	
//	public T get(int index) {
//		if(index > itemCount || index < 0) {
//			return null;
//		}
//		return this.array[index];
//	}
////		return (T) this.array[index];
		
		
   public void addToCart (String name, int price, int quantity) {
   
       Item temp = new Item(name, price, quantity);
       totalPrice += (price * quantity);
       array[itemCount] = temp;
       itemCount += 1;
       
       if(itemCount==capacity)
       {
           increaseSize();
       }
   }

   //add a remove method
   private void increaseSize()
   {
       Item[] temp = new Item[capacity * 2];
       for(int i=0; i < capacity; i++)
       {
           temp[i] = array[i];
       }
       array = temp; 
       temp = null;
       capacity = array.length;
   }
}
