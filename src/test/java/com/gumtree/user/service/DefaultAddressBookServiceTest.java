package com.gumtree.user.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gumtree.user.dao.FileAddressBookDao;
import com.gumtree.user.model.AddressBookException;
import com.gumtree.user.model.MockPerson;
import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public class DefaultAddressBookServiceTest {

	private DefaultAddressBookService addressBookService;


	@Before
	public void setUp() {
		// AddressBookDao addressBookDao = new MockAddressBookDao();
		FileAddressBookDao addressBookDao = new FileAddressBookDao();
		addressBookDao.setFileName("src/test/resources/AddressBook");

		addressBookService = new DefaultAddressBookService();
		addressBookService.setAddressBookDao(addressBookDao);
	}


	@Test
	public void getMaleCount() throws AddressBookException {
		long count = addressBookService.getPersonCountBySex(Sex.MALE);
		Assert.assertEquals(3, count);
	}

	@Test
	public void getOldestPerson() throws AddressBookException {
		Person person = addressBookService.getOldestPerson();
		Person expectedPerson = MockPerson.getWesJackson();
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
