package com.gumtree.user.model;

import java.time.LocalDate;
import java.time.Month;

public class MockPerson {

	public static Person getBillMcKnight() {
		LocalDate dateOfBirth = LocalDate.of(1977, Month.MARCH, 16);
		Person person = new Person();
		person.setFirstName("Bill");
		person.setLastName("McKnight");
		person.setSex(Sex.MALE);
		person.setDateOfBirth(dateOfBirth);
		return person;
	}

	public static Person getWesJackson() {
		LocalDate dateOfBirth = LocalDate.of(1974, Month.AUGUST, 14);
		Person person = new Person();
		person.setFirstName("Wes");
		person.setLastName("Jackson");
		person.setSex(Sex.MALE);
		person.setDateOfBirth(dateOfBirth);
		return person;
	}

	public static Person getPaulRobinson() {
		LocalDate dateOfBirth = LocalDate.of(1985, Month.JANUARY, 15);
		Person person = new Person();
		person.setFirstName("Paul");
		person.setLastName("Robinson");
		person.setSex(Sex.MALE);
		person.setDateOfBirth(dateOfBirth);
		return person;
	}

	public static Person getDavidCameron() {
		LocalDate dateOfBirth = LocalDate.of(1966, Month.OCTOBER, 9);
		Person person = new Person();
		person.setFirstName("David");
		person.setLastName("Cameron");
		person.setSex(Sex.MALE);
		person.setDateOfBirth(dateOfBirth);
		return person;
	}
}
