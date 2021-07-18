
package com.revature.menu;

import java.util.Scanner;

import com.revature.model.User;
import com.revature.services.UserServices;
import com.revature.util.SingletonScanner;

public class StartMenu {

	
	private UserServices us = new UserServices();
	private User loggedUser = null;
	private Scanner scan = SingletonScanner.getScanner().getScan();
	
	public void start() {

		 while(true) {
			switch(startMenu()) {
			case 1:
				System.out.println("Please enter your username: ");
				String username = scan.nextLine();
				User u = us.login(username);				
				if(u == null) {
					System.out.println("Please try again.");
				} else {
					loggedUser = u;
					System.out.println("Welcome back: "+u.getUsername());
					switch(loggedUser.getType()) {
					case CUSTOMER:
						customer();
						break;
					case SELLER:
						seller();
						break;
					}
				}
				break;
			case 2:
				//if (users != username)
				break;
			case 3:
				System.out.println("Goodbye!");
			default:
				System.out.println("Not a valid selection, please try again.");
			}
		 }
	}
	
	private int startMenu() {
		System.out.println("Welcome to Jasmine's Wallet");
		System.out.println("What would you like to do?");
		System.out.println("\t1. Login");
		System.out.println("\t2. Register");
		System.out.println("\t3. Quit");
		int selection = select();
		return selection;
	}
	
	public void customer() {
            while(true) {
			switch(customerMenu()) {
			case 1:
				shop();
				break;
				
			case 2: 
				// view cart
				System.out.println("You have _ in your cart" );
				break;
			case 3:
				// View Coupons
				break;
			case 4:
				System.out.println("Your total is $"   );
				break;
				
			case 5:
				loggedUser = null;
				System.out.println("Logout Successful!");
				start();
				break;
			}
			}
	}
	private int customerMenu() {
		System.out.println("What would you like to do?");
		System.out.println("\t1. Shop");
		System.out.println("\t2. View Cart");
		System.out.println("\t3. Check Coupons");
		System.out.println("\t4. Checkout");
		System.out.println("\t5. Logout");
		return select();
	}

	public void shop() {
		while(true) {
			
			switch(shopMenu()) {
			case 1:
                color();
			case 2: 
			case 3:
				break;
			case 4:
				customerMenu(); //need to fix
				break;
				}
			}
			}
	private int shopMenu() {
		System.out.println("What would you like to buy?");
		System.out.println("\t1. Standard Cash Envelopes - $3.00");
		System.out.println("\t2. Mini Cash Envelopes - $2.50");
		System.out.println("\t3. Cash Breakdown Card - $2.00");
		System.out.println("\t4. Main Menu");
		return select();
	}
	
	public void color() {
		
		while(true) {
			switch(colorMenu()) {
			case 1:
				System.out.println("++Added to Cart");
				break;
				
			case 2: 
				System.out.println("++Added to Cart");
				break;
				
			case 3:
				System.out.println("++Added to Cart");
				break;
			case 4:
				shopMenu();
				break;
				}
			
	}
			}
	private int colorMenu() {
		System.out.println("Which color would you like?");
		System.out.println("\t1. Blush Pink");
		System.out.println("\t2. White");
		System.out.println("\t3. Tan");
        System.out.println("\t4. Go Back");
		return select();
	}
	
	public void seller() {
		while(true) {
			
		switch(sellerMenu()) {
		    case 1:
		    	
			   addMenu();
			   break;
			   
			case 2:		
			// show new orders
				System.out.println("Orders Processed Successfully!");
				break;
				
			case 3:
				System.out.println("Logout Successful");
		}
	}		
	}	

	
	private int sellerMenu() {
			System.out.println("What would you like to do?");
			System.out.println("\t1. Add New Items");
			System.out.println("\t2. Process Orders");
			System.out.println("\t3. Logout");
			return select();
		}
	
//	public void add() {
//		while(true) {
//			
//		switch(addMenu()) {
//		    case 1:
//		    	
//			   //System.out.println("What would you like to add");
//			   break;
//			   
//			case 2:		
//			// show new orders
//				System.out.println("Orders Processed Successfully!");
//				break;
//				
//			case 3:
//				System.out.println("Logout Successful");
//		}
//	}		
//	}	

	
	private void addMenu() {
			System.out.println("What would you like to add?");
			//add.item = scan.nextLine();
			System.out.println("What is the price of the item?");
			//price.item = scan.nextFloat();
			//System.out.println("\t3. Logout");
			//return select();
		}
		
	
	
	private int select() {
		int selection;
		try {
			selection = Integer.parseInt(scan.nextLine());
		} catch(Exception e) {
			selection = -1;
		}
		return selection;
	}

}