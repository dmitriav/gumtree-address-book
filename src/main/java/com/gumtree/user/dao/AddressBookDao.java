package com.gumtree.user.dao;

import com.gumtree.user.model.AddressBookException;
import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public interface AddressBookDao {

	long getPersonCountBySex(Sex sex) throws AddressBookException;

	Person getOldestPerson() throws AddressBookException;

	Person getPersonByFirstName(String firstName) throws AddressBookException;
}
