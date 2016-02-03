package com.gumtree.user.dao;

import com.gumtree.user.model.MockPerson;
import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public class MockAddressBookDao implements AddressBookDao {

	@Override
	public int getPersonCountBySex(Sex sex) {
		if (sex == null) {
			return 0;
		}

		switch (sex) {
			case FEMALE: 
				return 2;
			case MALE:
				return 3;
			default:
				return 0;
		}
	}

	@Override
	public Person getOldestPerson() {
		Person person = MockPerson.getWesJackson();
		return person;
	}

	@Override
	public Person getPersonByFirstName(String firstName) {
		if (firstName == null) {
			return null;
		}

		Person person = null;

		if (firstName.equals("Bill")) {
			person = MockPerson.getBillMcKnight();
		}

		if (firstName.equals("Paul")) {
			person = MockPerson.getPaulRobinson();
		}

		if (firstName.equals("David")) {
			person = MockPerson.getDavidCameron();
			person.setDateOfBirth(null);
		}

		return person;
	}
}
