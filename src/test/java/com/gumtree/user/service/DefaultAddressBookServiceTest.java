package com.gumtree.user.service;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gumtree.user.dao.AddressBookDao;
import com.gumtree.user.dao.MockAddressBookDao;
import com.gumtree.user.model.AddressBookException;
import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public class DefaultAddressBookServiceTest {

	private DefaultAddressBookService addressBookService;


	@Before
	public void setUp() {
		AddressBookDao addressBookDao = new MockAddressBookDao();
		addressBookService = new DefaultAddressBookService();
		addressBookService.setAddressBookDao(addressBookDao);
	}


	@Test
	public void getMaleCount() {
		int count = addressBookService.getMaleCount();
		Assert.assertEquals(3, count);
	}

	@Test
	public void getOldestPerson() {
		Person person = addressBookService.getOldestPerson();

		LocalDate expectedDateOfBirth = LocalDate.of(1974, Month.AUGUST, 14);

		Person expectedPerson = new Person();
		expectedPerson.setFirstName("Wes");
		expectedPerson.setLastName("Jackson");
		expectedPerson.setSex(Sex.MALE);
		expectedPerson.setDateOfBirth(expectedDateOfBirth);

		Assert.assertEquals(expectedPerson, person);
	}

	@Test
	public void getAgeDifference() throws AddressBookException {
		long days = addressBookService.getAgeDifference("Bill", "Paul");
		Assert.assertEquals(2862, days);
	}

	@Test(expected = AddressBookException.class)
	public void getAgeDifferenceUnknownNames() throws AddressBookException {
		addressBookService.getAgeDifference("Tony", "David");
		Assert.fail("Should throw exception since unknown names");
	}

	@Test(expected = AddressBookException.class)
	public void getAgeDifferenceMissingDateOfBirth() 
			throws AddressBookException {
		addressBookService.getAgeDifference("Bill", "David");
		Assert.fail("Should throw exception since date of birth missing");
	}
}
