//
//package com.revature.menu;
//
//import java.util.Scanner;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.revature.beans.Item;
//import com.revature.beans.User;
//import com.revature.data.ItemDAO;
//import com.revature.services.UserServices;
//import com.revature.util.SingletonScanner;
//
//public class StartMenu {
//
//	private static final Logger log = LogManager.getLogger(StartMenu.class);
//	private UserServices us = new UserServices();
//	private User loggedUser = null;
//	private Scanner scan = SingletonScanner.getScanner().getScan();
//	private ItemDAO id = new ItemDAO();
//	
//	public void start() {
//		log.trace("Begin the shop application, StartMenu()");
//
//		main: while(true) {
//			 switch(startMenu()) {
//			case 1:
//				System.out.println("Please enter your username: ");
//				String username = scan.nextLine();
//				log.debug(username);
//				User u = us.login(username);				
//				if(u == null) {
//					log.warn("Unsuccessful login attempt");
//					System.out.println("Please try again.");
//					
//				} else {
//					loggedUser = u;
//					System.out.println("Welcome back: "+u.getUsername());
//					log.info("Succesful login in for: "+loggedUser);
//					switch(loggedUser.getType()) {
//					case CUSTOMER:
//						customer();
//						break;
//					case SELLER:
//						seller();
//						break;
//					}
//				}
//				break;
//			case 2:
//				System.out.println("Enter a username: ");
//				String newName = scan.nextLine();
//				log.debug(newName);
//				if(!us.checkAvailability(newName)) {
//					log.warn("username unavailable");
//					System.out.println("Username not available, please try again.");
//					
//					start();
//				}
//				System.out.println("Enter your email address: ");
//				String email = scan.nextLine();
//				log.debug(email);
//				us.register(newName, email);
//				System.out.println("Thank you for registering! You recieved a 10% off coupon.");
//				break;
//			case 3:
//				System.out.println("Goodbye!");
//				break main;
//				
//			default:
//				System.out.println("Not a valid selection, please try again.");
//			}
//		 }log.trace("ending application, LeavingShop()");
//	}
//	
//
//	private int startMenu() {
//		log.trace("starting start menu");
//		System.out.println("Welcome to Jasmine's Wallet");
//		System.out.println("What would you like to do?");
//		System.out.println("\t1. Login");
//		System.out.println("\t2. Register");
//		System.out.println("\t3. Quit");
//		int selection = select();
//		return selection;
//	}
//	
//	public void customer() {
//            while(true) {
//			switch(customerMenu()) {
//			case 1:
//				shop();
//				break;
//				
//			case 2: 
//				// view cart
//			    //System.out.println("Your total is: " + total);
//				
//				System.out.println("You have " +loggedUser.getCart() + " items in your cart" );
//				break;
//			case 3:
//				//get coupon
//				System.out.println("You have " + loggedUser.getCoupon() + "% off!");
//				break;
//			case 4:
//				System.out.println("Your total is $" );
//				System.out.println("Thank you for your purchase!");
//				break;
//				
//			case 5:
//				loggedUser = null;
//				System.out.println("Logout Successful!");
//				log.trace("logging out");
//				start();
//				break;
//			}
//			}
//	}
//	private int customerMenu() {
//		log.trace("starting customer menu");
//		System.out.println("What would you like to do?");
//		System.out.println("\t1. Shop");
//		System.out.println("\t2. View Cart");
//		System.out.println("\t3. View Coupons");
//		System.out.println("\t4. Checkout");
//		System.out.println("\t5. Logout");
//		return select();
//	}
//
//	public void shop() {
//		while(true) {
//			
//			switch(shopMenu()) {
//			case 1:
//				System.out.println("++Added to Cart");
//
//				id.getItemByItemID(1);
//				//id.getItemByName("Standard Cash Envelopes");
//				us.addToCart(loggedUser);
//				
//                break;
//			case 2:
//				System.out.println("++Added to Cart");
//				//id.getItemByName("Mini Cash Envelopes");
//				id.getItemByItemID(1);
//				us.addToCart(loggedUser);
//				break;
//			case 3:
//				System.out.println("++Added to Cart");
//				id.getItemByItemID(2);
//				us.addToCart(loggedUser);
//				break;
//			case 4:
//				customer(); 
//				break;
//				}
//			}
//			}
//	private int shopMenu() {
//		log.trace("starting shop menu");
//		System.out.println("What would you like to buy?");
//		System.out.println("\t1. Standard Cash Envelopes - $3.00");
//		System.out.println("\t2. Mini Cash Envelopes - $2.50");
//		System.out.println("\t3. Cash Breakdown Card - $2.00");
//		System.out.println("\t4. Main Menu");
//		return select();
//	}
//
//	
//	public void seller() {
//		while(true) {
//			
//		switch(sellerMenu()) {
//		    case 1:
//				System.out.println("What would you like to add?");
//				String newItem = scan.nextLine();
//				System.out.println("What is the price of the item?");
//				Double price = scan.nextDouble();
//				System.out.println("What is item ID number?");
//				int itemID = scan.nextInt();
//				System.out.println("Adding....");
//				System.out.println("Item added successfully!");
//				us.newItem(newItem, price, itemID);
//				break;
//			   
//			case 2:		
//			// show new orders
//			
//				System.out.println("Orders Processed Successfully!");
//				break;
//				
//			case 3:
//				System.out.println("Logout Successful!");
//				log.trace("logging out");
//				start();
//				break;
//		}
//	}		
//	}	
//
//	
//	private int sellerMenu() {
//		log.trace("starting seller menu");
//			System.out.println("What would you like to do?");
//			System.out.println("\t1. Add New Items");
//			System.out.println("\t2. Process Orders");
//			System.out.println("\t3. Logout");
//			return select();
//		}
//
//	
//	private int select() {
//		int selection;
//		try {
//			selection = Integer.parseInt(scan.nextLine());
//		} catch(Exception e) {
//			selection = -1;
//		}
//		return selection;
//	}
//
//}