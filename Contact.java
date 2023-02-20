/*
 * Ryan Reames
 * CS-320-T3331
 * 1/19/23
 * 
 * Module Three Milestone
 * 
 * Contact Class Requirements:
 * *In-memory data structure to store contacts
 * *Unique contact ID no longer than 10 characters not null, no updates
 * *firstName no longer than 10 characters, not null
 * *lastName no longer than 10 characters, not null
 * *phone exactly 10 digits, not null
 * *address no longer than 30 characters, not null
 */

package contact;

public class Contact {
	
	// The id String is set to final to avoid change after setting a value.
	// Uniqueness is checked in the ContactService class as multiple contacts are not stored within this class
	private final String id;
	public String firstName, lastName, phone, address;
	private String regex = "[0-9]+"; // Used to verify phone number input
	
	// This constructor checks id value for uniqueness / validity before assigning values to the object using setters
	public Contact(String id, String firstName, String lastName, String phone, String address)
	{	
		if(id == null || id.length() > 10) 
		{ 
			throw new IllegalArgumentException("Invalid ID.");
		}
		this.id = id;
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}

	// Setters and getters for each attribute, aside from id which only has a getter
	// Each setter includes requirements for length and null values, as well as digits only for phone number 
	
	public String getId() {
		if(this.id == null)
		{
			throw new NullPointerException("Doesn't exist");
		}
		return id;
	}

	public String getFirstName() {
		if(this.firstName == null)
		{
			throw new NullPointerException("Doesn't exist");
		}
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10) 
		{ 
			throw new IllegalArgumentException("Invalid first name.");
		}
		else
		{
			this.firstName = firstName;
		}
	}

	public String getLastName() {
		if(this.lastName == null)
		{
			throw new NullPointerException("Doesn't exist");
		}
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName == null || lastName.length() > 10) 
		{ 
			throw new IllegalArgumentException("Invalid last name.");
		}
		else
		{
			this.lastName = lastName;
		}
	}

	public String getPhone() {
		if(this.phone == null)
		{
			throw new NullPointerException("Doesn't exist");
		}
		return phone;
	}

	public void setPhone(String phone) {
		if(phone == null || phone.length() > 10 || !phone.matches(regex)) 
		{ 
			throw new IllegalArgumentException("Invalid phone.");
		}
		else
		{
			this.phone = phone;
		}
	}

	public String getAddress() {
		if(this.address == null)
		{
			throw new NullPointerException("Doesn't exist");
		}
		return address;
	}

	public void setAddress(String address) {
		if(address == null || address.length() > 30) 
		{ 
			throw new IllegalArgumentException("Invalid address.");
		}
		else
		{
			this.address = address;
		}
	}
	
}
