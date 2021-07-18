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
				// register
				break;
			case 3:
				// quit
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
	
	private int customer() {

			switch(customerMenu()) {
			case 1:
				// Shop Switch to shop menu
				System.out.println("What would you like to buy?");
//				System.out.println("\t1. Standard Cash Envelopes");
//				System.out.println("\t2. Mini Cash Envelopes");
//				System.out.println("\t3. Cash Breakdown Card");
				
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
				loggedUser = null;
				break;
				}
			return 0;
			}

		
	//}
	
	private int customerMenu() {
		System.out.println("What would you like to do?");
		System.out.println("\t1. Shop");
		System.out.println("\t2. View Cart");
		System.out.println("\t3. Check Coupons");
		System.out.println("\t4. Checkout");
		System.out.println("\t5. Logout");
		return select();
	}
	private void seller() {
		seller: while(true) {
			
		}
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