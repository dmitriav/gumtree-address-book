package com.gumtree.user.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.user.dao.AddressBookDao;
import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public class DefaultAddressBookService implements AddressBookService {

	private static Logger logger = LoggerFactory.getLogger(
			DefaultAddressBookService.class);

	private AddressBookDao addressBookDao;


	@Override
	public int getMaleCount() {
		int count = addressBookDao.getCountBySex(Sex.MALE);
		logger.debug("Address book has {} males", count);
		return count;
	}

	@Override
	public Person getOldestPerson() {
		Person person = addressBookDao.getOldestPerson();
		logger.debug("{} is the oldest person", person);
		return person;
	}

	@Override
	public int getAgeDifference(String firstName, String otherFirstName) {
		Person person = addressBookDao.getPersonByFirstName(firstName);
		Person otherPerson = addressBookDao.getPersonByFirstName(otherFirstName);

		// TODO: add exception if null objects returned

		LocalDate dateOfBirth = person.getDateOfBirth();
		LocalDate otherDateOfBirth = otherPerson.getDateOfBirth();
		long days = ChronoUnit.DAYS.between(dateOfBirth, otherDateOfBirth);

		// TODO: change interface to return a long type

		logger.debug("The age difference between {} and {} is {} day(s)", 
				firstName, otherFirstName, days);

		return (int) days;
	}


	public void setAddressBookDao(AddressBookDao addressBookDao) {
		this.addressBookDao = addressBookDao;
	}
}
