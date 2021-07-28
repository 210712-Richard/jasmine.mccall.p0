package com.revature.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.beans.UserType;
import com.revature.data.ItemDAO;
import com.revature.services.UserServices;
import io.javalin.http.Context;




public class UserController {
	private static Logger log = LogManager.getLogger(UserController.class);
	private UserServices us = new UserServices();
	
	public void login(Context ctx) {
		log.trace("Login method called");
		log.debug(ctx.body());
		User u = ctx.bodyAsClass(User.class);
		log.debug(u);
		u = us.login(u.getUsername());
		log.debug(u);
		
		if(u != null) {
			ctx.sessionAttribute("loggedUser", u);
		    ctx.json(u);
		    return;
		}
		
		ctx.status(401);
	}
	public void getCoupon(Context ctx) {
		String username = ctx.pathParam("username");
		User loggedUser = (User) ctx.sessionAttribute("loggedUser");
		if(loggedUser == null || !loggedUser.getUsername().equals(username)) {
			ctx.status(403);
			log.warn("User forbidden");
			return;
		}
			ctx.json(loggedUser.getCoupon());
			log.trace("User can see coupon");
		
		
	}
	public void logout(Context ctx) {
		ctx.req.getSession().invalidate();
		ctx.status(204);
		log.trace("Logging out");
	}
	public void register(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		log.debug(ctx.body());
		
		if (us.checkAvailability(u.getUsername())){
				User newUser = us.register(u.getUsername(), u.getEmail());
				ctx.status(201);
				ctx.json(newUser);
		}else {
			ctx.status(409);
			ctx.html("Username already Taken");
			log.warn("Username already Taken");
		}
	} 
		public void addToCart(Context ctx) {
			User loggedUser = (User) ctx.sessionAttribute("loggedUser");
			String username = ctx.pathParam("username");
			Item item = (Item)ctx.bodyAsClass(Item.class);
			if(loggedUser == null || !loggedUser.getUsername().equals(username)) {
				ctx.status(403);
				log.warn("User forbidden");
				return;
			}
			Item add = us.addToCart(loggedUser, item.getItemID());
			
			ctx.json(add);
	}
		public void removeFromCart(Context ctx) {
			User loggedUser = (User) ctx.sessionAttribute("loggedUser");
			String username = ctx.pathParam("username");
			Item item = (Item)ctx.bodyAsClass(Item.class);
			if(loggedUser == null || !loggedUser.getUsername().equals(username)) {
				ctx.status(403);
				log.warn("User forbidden");
				return;
			}
			Item remove = us.removeFromCart(loggedUser, item.getItemID());
			
			ctx.json(remove);
		}
		
		public void viewShop(Context ctx) {
			ItemDAO id = new ItemDAO();
			id.getItem();
			ctx.json(id);
		
		}
	public void addItemToShop(Context ctx) {
		User loggedUser = (User) ctx.sessionAttribute("loggedUser");	
		 if(!loggedUser.getType().equals(UserType.SELLER))  {
				ctx.status(403);
				return;
				}
		Item i = ctx.bodyAsClass(Item.class);
		Item newItems = us.newItem(i.getName(),i.getPrice());
		ctx.json(newItems);
	}
	public void viewCart(Context ctx) {
		User loggedUser = (User) ctx.sessionAttribute("loggedUser");
		String username = ctx.pathParam("username");
		if(loggedUser == null || !loggedUser.getUsername().equals(username)) {
			ctx.status(403);
			log.warn("User forbidden");
				ctx.status(403);
				return;
				}
		   ctx.json(loggedUser.getCart());
	}

	public void checkout (Context ctx){
		User loggedUser = (User) ctx.sessionAttribute("loggedUser");
		String username = ctx.pathParam("username");
		//Item item = (Item)ctx.bodyAsClass(Item.class);
		//log.debug(ctx.body());
		if(loggedUser == null || !loggedUser.getUsername().equals(username)) {
			ctx.status(403);
			log.warn("User forbidden");
			return;
			}
		
		//ItemDAO id = new ItemDAO();
		
		Double total = us.checkout(loggedUser);
		//id.cartTotal(total);
		ctx.json(total);
		
	}

	public void processOrders(Context ctx) {
		User loggedUser = (User) ctx.sessionAttribute("loggedUser");	
		 if(!loggedUser.getType().equals(UserType.SELLER))  {
				ctx.status(403);
				return;
			
		 }
		User user = new User();
		  if (!user.getCart().isEmpty() && user.getType().equals(UserType.CUSTOMER)) {
			  us.processOrders();
			 ctx.json(user);
	}
		  
	}
}


