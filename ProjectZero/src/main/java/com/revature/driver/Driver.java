package com.revature.driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.controllers.UserController;





import io.javalin.Javalin;
import io.javalin.plugin.json.JavalinJackson;

public class Driver {
	public static void main(String[] args) {
		ObjectMapper jackson = new ObjectMapper();
		jackson.registerModule(new JavaTimeModule());
		jackson.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		JavalinJackson.configure(jackson);
		
		Javalin app = Javalin.create().start(8080);
		UserController uc = new UserController();
		
		
		app.get("/", (ctx) ->ctx.html("Hello World"));
		
		app.post("/users", uc::login);
		app.put("/users/:username", uc::register);
		app.get("/users/:username/coupon", uc::getCoupon);
		app.delete("/users", uc::logout);
		app.post("/users/:username/shop", uc::addToCart);
		app.get("/items", uc::viewShop);
		app.put("/seller", uc::addItemToShop);
		app.post("/users/:username/checkout", uc::checkout);
		app.delete("/users/:username/shop/remove", uc::removeFromCart);
		app.get("/users/:username/cart", uc::viewCart);
		app.delete("/seller/:username/processOrders", uc::processOrders);
				
				
				
	}
}


























//package com.revature.driver;
//

//
//public class Driver {
//		public static void main(String[] args) {
//			StartMenu m = new StartMenu();
//			m.start();
//
//		}
//
//}
