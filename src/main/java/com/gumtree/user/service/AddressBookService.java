package com.gumtree.user.service;

import com.gumtree.user.model.Person;

public interface AddressBookService {

	int getMaleCount();

	Person getOldestPerson();

	int getAgeDifference(String firstName, String otherFirstName);
}
