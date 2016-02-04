package com.gumtree.user.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gumtree.user.model.AddressBookException;
import com.gumtree.user.model.MockPerson;
import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public class FileAddressBookDaoTest {

	private FileAddressBookDao addressBookDao;


	@Before
	public void setUp() {
		addressBookDao = new FileAddressBookDao();
		addressBookDao.setFileName("src/test/resources/AddressBook");
	}


	@Test
	public void getPersonCountBySex() throws AddressBookException {
		long count = 0; 

		count = addressBookDao.getPersonCountBySex(Sex.MALE);
		Assert.assertEquals(3, count);

		count = addressBookDao.getPersonCountBySex(Sex.FEMALE);
		Assert.assertEquals(2, count);

		count = addressBookDao.getPersonCountBySex(null);
		Assert.assertEquals(0, count);
	}

	@Test
	public void getPersonCountBySexAddressBookEmpty() 
			throws AddressBookException {
		addressBookDao.setFileName("src/test/resources/AddressBookEmpty");
		long count = addressBookDao.getPersonCountBySex(Sex.MALE);
		Assert.assertEquals(0, count);
	}

	@Test(expected = AddressBookException.class)
	public void getPersonCountBySexInvalidAddressBookFile() 
			throws AddressBookException {
		addressBookDao.setFileName("src/test/resources/AddressBookInvalid");
		addressBookDao.getPersonCountBySex(Sex.MALE);
		Assert.fail("Should throw exception since file is invalid");
	}

	@Test
	public void getOldestPerson() {
		Person person = addressBookDao.getOldestPerson();
		Person expectedPerson = MockPerson.getWesJackson();
		Assert.assertEquals(expectedPerson, person);
	}

	@Test
	public void getPersonByFirstName() throws AddressBookException {
		Person person = addressBookDao.getPersonByFirstName(" WES ");
		Person expectedPerson = MockPerson.getWesJackson();
		Assert.assertEquals(expectedPerson, person);
	}

	@Test
	public void getPersonByUnknownFirstName() throws AddressBookException {
		Person person = addressBookDao.getPersonByFirstName("Tony");
		Assert.assertNull(person);
	}
}
