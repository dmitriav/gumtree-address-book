package com.gumtree.user.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public class DefaultAddressBookServiceTest {

	private DefaultAddressBookService addressBookService;


	@Before
	public void setUp() {
		addressBookService = new DefaultAddressBookService();
	}


	@Test
	public void getMaleCount() {
		int count = addressBookService.getMaleCount();
		Assert.assertEquals(3, count);
	}

	@Test
	public void getOldestPerson() {
		Person person = addressBookService.getOldestPerson();

		Person expectedPerson = new Person();
		expectedPerson.setFirstName("Wes");
		expectedPerson.setLastName("Jackson");
		expectedPerson.setSex(Sex.MALE);
		expectedPerson.setDateOfBirth("14/08/74");

		Assert.assertEquals(expectedPerson, person);
	}

	@Test
	public void getAgeDifference() {
		int days = addressBookService.getAgeDifference("Bill", "Paul");
		Assert.assertEquals(2890, days);
	}
}
