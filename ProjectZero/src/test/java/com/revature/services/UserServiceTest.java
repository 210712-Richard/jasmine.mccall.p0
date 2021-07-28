package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Period;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.revature.beans.Item;
import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.data.ItemDAO;

public class UserServiceTest {
	private static UserServices service = null;
	private static User u;
	private static Item i;
	
	
	@BeforeAll
	public static void setUpClass() {
		u = new User();
		u.setUsername("Test");
		i = new Item(null, null);
		
		
	}
	
	@BeforeEach
	public void setUpTests() {
		service = new UserServices();
		u.setLastCheckIn(LocalDate.of(2021, 1, 1));
		service.ud = Mockito.mock(UserDAO.class);
		service.id = Mockito.mock(ItemDAO.class);
	}
	@Test
	public void testDoCheckIn() {
		Integer coupon = u.getCoupon();
		assertNotEquals(LocalDate.now(), u.getLastCheckIn(), "Checking to see if the date is NOT today");
		service.doCheckIn(u);
		assertEquals(LocalDate.now(), u.getLastCheckIn(), "Checking to see if the date is today");
		assertEquals(coupon, u.getCoupon(), "Checking to see if coupon is correct");
		Mockito.verify(service.ud).writeToFile();
	}
	
	@Test
	public void testHasCheckedInThrowsException() {
		assertThrows(NullPointerException.class, () -> { service.hasCheckedIn(null);});
	}

	@Test
	public void testHasCheckedInReturnsFalse() {
		Boolean hasCheckedIn = service.hasCheckedIn(u);
		assertFalse(hasCheckedIn);
		assertFalse(service.hasCheckedIn(u));
		LocalDate yesterday = LocalDate.now().minus(Period.of(0, 0, 1));
		u.setLastCheckIn(yesterday);
		assertFalse(service.hasCheckedIn(u));
	}
	@Test
	public void testHasCheckedInReturnsTrue() {
		u.setLastCheckIn(LocalDate.now());
		assertTrue(service.hasCheckedIn(u));
	}
	@Test
	public void testAddNewItem() {
		String name = "test";
		Double price = 0D;
		//Integer itemID = 0;
		service.newItem(name, price);
		ArgumentCaptor<Item> captor = ArgumentCaptor.forClass(Item.class);
		Mockito.verify(service.id).addItem(captor.capture());
		Mockito.verify(service.id).writeToFile();
		
		Item i = captor.getValue();
		assertEquals(name, i.getName(), "Asserting item name is correct");
		assertEquals(price, i.getPrice(), "Asserting item price is correct");
		//assertEquals(itemID, i.getItemID(), "Asserting item id is correct");

	}
}
