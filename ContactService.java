/*
 * Ryan Reames
 * CS-320-T3331
 * 1/19/23
 * 
 * Module Three Milestone
 * 
 * Contact Service Class Requirements:
 * *add contacts with unique ID
 * *delete contacts per contact ID
 * *update firstName, lastName, number, address
 */

package contact;

import java.util.HashMap;

public class ContactService {
	
	// Singleton pattern for ContactService class so only one instance may be called
	private static ContactService contactService = new ContactService();
	private ContactService() {}
	public static ContactService getContactService()
	{
		return contactService;
	}
	
	// Hash map allows unique id connected to contact, and easy removal when deleting
	public HashMap<String, Contact> userContacts = new HashMap<String, Contact>();
	
	// Checks if ID is in use, and if not, adds new contact to HashMap
	public void addContact(String id, String firstName, String lastName, String phone, String address)
	{
		if(userContacts.containsKey(id))
		{
			throw new IllegalArgumentException("ID already used");
		}
		Contact newContact = new Contact(id, firstName, lastName, phone, address);
		userContacts.put(id, newContact);
	}
	
	// Uses HashMap to delete contact based on id
	public void deleteContact(String id)
	{
		userContacts.remove(id);
		
	}
	
	/*
	 *  The following four methods check if an ID is in the HashMap, and then updates the related field if so.
	 *
	 *  If the ID is not included, an exception is thrown.
	 */
	
	public void updateFirstName(String id, String firstName)
	{
		if(!userContacts.containsKey(id))
		{
			throw new IllegalArgumentException("ID does not exist");
		}
		userContacts.get(id).setFirstName(firstName);
	}
	
	public void updateLastName(String id, String lastName)
	{
		if(!userContacts.containsKey(id))
		{
			throw new IllegalArgumentException("ID does not exist");
		}
		userContacts.get(id).setLastName(lastName);
	}
	
	public void updatePhone(String id, String phone)
	{
		if(!userContacts.containsKey(id))
		{
			throw new IllegalArgumentException("ID does not exist");
		}
		userContacts.get(id).setPhone(phone);
	}
	
	public void updateAddress(String id, String address)
	{
		if(!userContacts.containsKey(id))
		{
			throw new IllegalArgumentException("ID does not exist");
		}
		userContacts.get(id).setAddress(address);
	}
	
}
