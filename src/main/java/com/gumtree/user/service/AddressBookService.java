package com.gumtree.user.service;

import com.gumtree.user.model.AddressBookException;
import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public interface AddressBookService {

	long getPersonCountBySex(Sex sex);

	Person getOldestPerson();

	long getAgeDifference(String firstName, String otherFirstName) 
			throws AddressBookException;
}
