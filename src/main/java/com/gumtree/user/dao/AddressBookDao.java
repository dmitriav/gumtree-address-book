package com.gumtree.user.dao;

import com.gumtree.user.model.AddressBookException;
import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

/**
 * A DAO for address book management. 
 * 
 * @author Dmitri Avdejev
 * @since 03/02/2016
 */
public interface AddressBookDao {

	/**
	 * Calculates the total number of contacts with the specified sex. 
	 * 
	 * @param sex
	 * @return A total number of contacts with the specified sex
	 * @throws AddressBookException if there's a system error
	 */
	long getPersonCountBySex(Sex sex) throws AddressBookException;

	/**
	 * Retrieves the oldest person from the configured address book. 
	 * 
	 * @return A fully populated Person instance or null if there's no contacts
	 * @throws AddressBookException if there's a system error
	 */
	Person getOldestPerson() throws AddressBookException;

	/**
	 * Retrieves a contact by the specified first name.
	 *  
	 * @param firstName
	 * @return A fully populated Person instance or null if name not found 
	 * @throws AddressBookException if there's a system error
	 */
	Person getPersonByFirstName(String firstName) throws AddressBookException;
}
