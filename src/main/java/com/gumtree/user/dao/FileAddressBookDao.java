package com.gumtree.user.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public class FileAddressBookDao implements AddressBookDao {

	private static Logger logger = LoggerFactory.getLogger(
			FileAddressBookDao.class);

	private String fileName;


	@Override
	public int getPersonCountBySex(Sex sex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Person getOldestPerson() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Person getPersonByFirstName(String firstName) {
		throw new UnsupportedOperationException();
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
