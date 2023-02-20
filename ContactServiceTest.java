/*
 * Ryan Reames
 * CS-320-T3331
 * 1/19/23
 * 
 * Module Three Milestone
 * 
 * This class tests the ContactService class with 100% coverage.
 */

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import contact.ContactService;

class ContactServiceTest {
	
	ContactService contactService = ContactService.getContactService();
	
	// Make sure contact service singleton works
	@Test
	void testContactService()
	{
		assertDoesNotThrow(() -> {ContactService testService = ContactService.getContactService();});
	}
	
	// Making sure delete actually goes through by checking id value before and after deletion
	@Test
	void testDeleteContact()
	{
		contactService.addContact("1","fname","lname","1234567890","address");
		assertTrue(contactService.userContacts.get("1").getId().equals("1"));
		contactService.deleteContact("1");
		assertThrows(NullPointerException.class, () -> 
		{
			contactService.userContacts.get("1").getId();
		});
	}
	
	// Adding a contact
	@Test
	void testAddContact()
	{
		assertDoesNotThrow(() -> 
		{
			contactService.addContact("2","firstName","lastName","1234567890","address");
		});
	}
	
	// Trying to add two contacts with same ID
	@Test
	void testUniqueContact()
	{
		contactService.addContact("3","Bobby","Test","1234567899","address here");
		assertThrows(IllegalArgumentException.class, () -> 
		{
			contactService.addContact("3","firstName","lastName","1234567890","address");
		});
	}
	
	/*
	 *  The next four tests try to update a value for a non-existing ID
	 */
	
	@Test
	void testNullUpdateFirstName()
	{
		assertThrows(IllegalArgumentException.class, () ->
		{
			contactService.updateFirstName("1000", "Vinnie");
		});
	}
	
	@Test
	void testNullUpdateLastName()
	{
		assertThrows(IllegalArgumentException.class, () ->
		{
			contactService.updateLastName("1000", "Vincenzo");
		});
	}
	
	@Test
	void testNullPhone()
	{
		assertThrows(IllegalArgumentException.class, () ->
		{
			contactService.updatePhone("1000", "9999999999");
		});
	}
	
	@Test
	void testNullUpdateAddress()
	{
		assertThrows(IllegalArgumentException.class, () ->
		{
			contactService.updateAddress("1000", "123 Street Street");
		});
	}
	
	/*
	 *  The following four tests update a value for a given contact.
	 */
	
	@Test
	void testUpdateFirstName()
	{
		contactService.addContact("10","firstName","lastName","1234567890","address");
		assertDoesNotThrow(() -> 
		{
			contactService.updateFirstName("10","Bobby");
		});
	}
	
	@Test
	void testUpdateLastName()
	{
		contactService.addContact("11","firstName","lastName","1234567890","address");
		assertDoesNotThrow(() -> 
		{
			contactService.updateLastName("11","Tester");
		});
	}
	
	@Test
	void testUpdatePhone()
	{
		contactService.addContact("12","firstName","lastName","1234567890","address");
		assertDoesNotThrow(() -> 
		{
			contactService.updatePhone("12","8888888888");
		});
	}
	
	@Test
	void testUpdateAddress()
	{
		contactService.addContact("13","firstName","lastName","1234567890","address");
		assertDoesNotThrow(() -> 
		{
			contactService.updateAddress("13","321 Go Street");
		});
	}
}
