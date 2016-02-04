package com.gumtree.user.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.user.dao.AddressBookDao;
import com.gumtree.user.model.AddressBookException;
import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public class DefaultAddressBookService implements AddressBookService {

	private static Logger logger = LoggerFactory.getLogger(
			DefaultAddressBookService.class);

	private AddressBookDao addressBookDao;


	@Override
	public long getPersonCountBySex(Sex sex) {
		long count = addressBookDao.getPersonCountBySex(sex);
		logger.debug("Address book has {} {}(s)", count, sex);
		return count;
	}

	@Override
	public Person getOldestPerson() {
		Person person = addressBookDao.getOldestPerson();
		logger.debug("{} is the oldest person", person);
		return person;
	}

	@Override
	public long getAgeDifference(String firstName, String otherFirstName) 
			throws AddressBookException {
		Person person = addressBookDao.getPersonByFirstName(firstName);
		if (person == null) {
			logger.warn("{} not found", firstName);
			throw new AddressBookException();
		}

		Person otherPerson = addressBookDao.getPersonByFirstName(otherFirstName);
		if (otherPerson == null) {
			logger.warn("{} not found", otherFirstName);
			throw new AddressBookException();
		}

		LocalDate dateOfBirth = person.getDateOfBirth();
		if (dateOfBirth == null) {
			logger.warn("Date of birth missing for {}", person);
			throw new AddressBookException();
		}

		LocalDate otherDateOfBirth = otherPerson.getDateOfBirth();
		if (otherDateOfBirth == null) {
			logger.warn("Date of birth missing for {}", otherPerson);
			throw new AddressBookException();
		}

		long days = ChronoUnit.DAYS.between(dateOfBirth, otherDateOfBirth);

		logger.debug("The age difference between {} and {} is {} day(s)", 
				firstName, otherFirstName, days);

		return days;
	}


	public void setAddressBookDao(AddressBookDao addressBookDao) {
		this.addressBookDao = addressBookDao;
	}
}
