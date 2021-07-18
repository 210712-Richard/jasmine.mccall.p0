package com.revature.menu;

import java.util.Scanner;

import com.revature.model.User;
import com.revature.services.UserServices;
import com.revature.util.SingletonScanner;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

// Encapsulate the user interface methods
public class StartMenu {

	//private static final Logger log = LogManager.getLogger(Menu.class);
	
	private UserServices us = new UserServices();
	private User loggedUser = null;
	private Scanner scan = SingletonScanner.getScanner().getScan();
	
	public void start() {
		//log.trace("Begin the GachaGame application. start()");
		 while(true) {
			switch(startMenu()) {
			case 1:
				// login
				System.out.println("Please enter your username: ");
				String username = scan.nextLine();
				//log.debug(username);
				// Call the user service to find the user we want.
				User u = us.login(username);
				if(u == null) {
					//log.warn("Unsuccessful login attempt: "+ username);
					System.out.println("Please try again.");
				} else {
					loggedUser = u;
					System.out.println("Welcome back: "+u.getUsername());
					// call our next method (either the Player menu or the Admin menu, depending on user)
					//log.info("Successful login for user: "+loggedUser);
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
				// invalid selection
				System.out.println("Not a valid selection, please try again.");
			}
		}
		//log.trace("Ending start()");
	}
	
	private int startMenu() {
		//log.trace("called startMenu()");
		System.out.println("Welcome to Jasmine's Wallet");
		System.out.println("What would you like to do?");
		System.out.println("\t1. Login");
		System.out.println("\t2. Register");
		System.out.println("\t3. Quit");
		int selection = select();
		//log.trace("Start menu returning selection: "+selection);
		return selection;
	}
	
	private int customer() {
		//log.trace("called player()");
		//customer: while(true) {
			switch(customerMenu()) {
			case 1:
				// Shop Switch to shop menu
				System.out.println("What would you like to buy?");
				System.out.println("\t1. Standard Cash Envelopes");
				System.out.println("\t2. Mini Cash Envelopes");
				System.out.println("\t3. Cash Breakdown Card");
				
				//return select();
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
		//log
		return selection;
	}

}