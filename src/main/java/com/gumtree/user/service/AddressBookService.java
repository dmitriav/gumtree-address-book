package com.gumtree.user.service;

import com.gumtree.user.model.AddressBookException;
import com.gumtree.user.model.Person;

public interface AddressBookService {

	int getMaleCount();

	Person getOldestPerson();

	long getAgeDifference(String firstName, String otherFirstName) 
			throws AddressBookException;
}
