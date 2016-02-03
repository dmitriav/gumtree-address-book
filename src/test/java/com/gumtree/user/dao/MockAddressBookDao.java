package com.gumtree.user.dao;

import java.time.LocalDate;
import java.time.Month;

import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public class MockAddressBookDao implements AddressBookDao {

	@Override
	public int getCountBySex(Sex sex) {
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
		LocalDate dateOfBirth = LocalDate.of(1974, Month.AUGUST, 14);

		Person person = new Person();
		person.setFirstName("Wes");
		person.setLastName("Jackson");
		person.setSex(Sex.MALE);
		person.setDateOfBirth(dateOfBirth);

		return person;
	}

	@Override
	public Person getPersonByFirstName(String firstName) {
		if (firstName == null) {
			return null;
		}

		if (firstName.equals("Bill")) {
			LocalDate dateOfBirth = LocalDate.of(1977, Month.MARCH, 16);
			Person person = new Person();
			person.setFirstName("Bill");
			person.setLastName("McKnight");
			person.setSex(Sex.MALE);
			person.setDateOfBirth(dateOfBirth);
			return person;
		}

		if (firstName.equals("Paul")) {
			LocalDate dateOfBirth = LocalDate.of(1985, Month.JANUARY, 15);
			Person person = new Person();
			person.setFirstName("Paul");
			person.setLastName("Robinson");
			person.setSex(Sex.MALE);
			person.setDateOfBirth(dateOfBirth);
			return person;
		}

		if (firstName.equals("David")) {
			Person person = new Person();
			person.setFirstName("David");
			person.setLastName("Cameron");
			person.setSex(Sex.MALE);
			person.setDateOfBirth(null);
			return person;
		}

		return null;
	}
}
