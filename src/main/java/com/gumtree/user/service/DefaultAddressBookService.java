package com.gumtree.user.service;

import com.gumtree.user.model.Person;

public class DefaultAddressBookService implements AddressBookService {

	@Override
	public int getMaleCount() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Person getOldestPerson() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getAgeDifference(String firstName, String otherFirstName) {
		throw new UnsupportedOperationException();
	}
}
