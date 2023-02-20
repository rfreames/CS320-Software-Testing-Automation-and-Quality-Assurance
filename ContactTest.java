/*
 * Ryan Reames
 * CS-320-T3331
 * 1/19/23
 * 
 * Module Three Milestone
 * 
 * This class tests the Contact class with 96.7% coverage.
 * I'm unsure how to test a private final variable as null, 
 * resulting in the less than 100% coverage.
 */

package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import contact.Contact;

class ContactTest {

	// Used in tests
	Contact baseContact = new Contact("1","firstName","lastName","1234567890","address");

	// Making sure Contact initialization works
	@Test
	void testValidContactId() 
	{
		assertDoesNotThrow(() -> {
			new Contact("1","firstName","lastName","1234567890","address");
		});
	}
	
	/*
	 * The following five tests check that null values throw an exception.
	 */
	
	@Test
	void testNullContactId() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null,"firstName","lastName","1234567890","address");
		});
	}
	
	@Test
	void testNullFirstName()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			baseContact.setFirstName(null);
		});
	}

	@Test
	void testNullLastName()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			baseContact.setLastName(null);
		});
	}
	
	@Test
	void testNullPhone()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			baseContact.setPhone(null);
		});
	}
	
	@Test
	void testNullAddress()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			baseContact.setAddress(null);
		});
	}
	
	/*
	 * The following five tests provide input that exceeds the limit to check for exceptions.
	 */
	
	@Test
	void testLongId() 
	{
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456789011","firstName","lastName","1234567890","address");
		});
	}
	
	@Test
	void testLongFirstName()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			baseContact.setFirstName("toolongofaname");
		});
	}
	
	@Test
	void testLongLastName()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			baseContact.setLastName("toolongofaname");
		});
	}
	
	@Test
	void testLongPhone()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			baseContact.setPhone("123456789010");
		});
	}
	
	@Test
	void testLongAddress()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			baseContact.setAddress("12345678901011121314151617181920");
		});
	}
	
	// Making sure phone value only accepts digits	
	@Test
	void testIncorrectPhone()
	{
		assertThrows(IllegalArgumentException.class, () -> {
			baseContact.setPhone("a");
		});
	}
	
	/*
	 * The following five tests check that the correct value is returned for
	 * a correctly set up contact.
	 */
	
	@Test
	void getId()
	{
		assertTrue(baseContact.getId().equals("1"));
	}
	
	@Test
	void getFirstName()
	{
		assertTrue(baseContact.getFirstName().equals("firstName"));
	}
	
	@Test
	void getLastName()
	{
		assertTrue(baseContact.getLastName().equals("lastName"));
	}
	
	@Test
	void getPhone()
	{
		assertTrue(baseContact.getPhone().equals("1234567890"));
	}
	
	@Test
	void getAddress()
	{
		assertTrue(baseContact.getAddress().equals("address"));
	}
	
	/*
	 * The remaining tests check that an exception is thrown when trying to get non-existing values.
	 * Unable to test id value as it is a private final variable.
	 */
	
// Not sure how to test this given the private id variable	
//	@Test
//	void nullId()
//	{
//		baseContact.id = null;
//		assertThrows(NullPointerException.class, () ->{
//			baseContact.getId();
//		});
//	}
	
	@Test
	void nullFirstName()
	{
		baseContact.firstName = null;
		assertThrows(NullPointerException.class, () ->{
			baseContact.getFirstName();
		});
	}
	
	@Test
	void nullLastName()
	{
		baseContact.lastName = null;
		assertThrows(NullPointerException.class, () ->{
			baseContact.getLastName();
		});
	}
	
	@Test
	void nullPhone()
	{
		baseContact.phone = null;
		assertThrows(NullPointerException.class, () ->{
			baseContact.getPhone();
		});
	}
	
	@Test
	void nullAddress()
	{
		baseContact.address = null;
		assertThrows(NullPointerException.class, () ->{
			baseContact.getAddress();
		});
	}
}
