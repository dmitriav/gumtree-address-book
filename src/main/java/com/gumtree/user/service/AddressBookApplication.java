package com.gumtree.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.user.dao.FileAddressBookDao;
import com.gumtree.user.model.AddressBookException;
import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

/**
 * This is a solution application for Gumtree coding challenge. 
 * 
 * @author Dmitri Avdejev
 * @since 04/02/2016
 */
public class AddressBookApplication {

	private static Logger logger = LoggerFactory.getLogger(
			AddressBookApplication.class);


	public static void main(String [] arguments) throws AddressBookException {
		FileAddressBookDao addressBookDao = new FileAddressBookDao();
		addressBookDao.setFileName("src/main/resources/AddressBook");

		DefaultAddressBookService addressBookService 
				= new DefaultAddressBookService();
		addressBookService.setAddressBookDao(addressBookDao);

		long maleCount = addressBookService.getPersonCountBySex(Sex.MALE);
		Person oldestPerson = addressBookService.getOldestPerson();
		long ageDifference = addressBookService.getAgeDifference("Bill", "Paul");

		logger.debug("Address book has {} male(s)", maleCount);
		logger.debug("The oldest person is {}", oldestPerson);
		logger.debug("Bill is older than Paul by {} days", ageDifference);
	}
}
