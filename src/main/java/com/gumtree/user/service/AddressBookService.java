package com.gumtree.user.service;

import com.gumtree.user.model.AddressBookException;
import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

/**
 * A service for address book management. 
 * 
 * @author Dmitri Avdejev
 * @since 03/02/2016
 */
public interface AddressBookService {

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
	 * Calculates the age difference between the specified contacts in days. 
	 * 
	 * @param firstName
	 * @param otherFirstName
	 * @return A number of days
	 * @throws AddressBookException if there's a system error
	 */
	long getAgeDifference(String firstName, String otherFirstName) 
			throws AddressBookException;
}
