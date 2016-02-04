package com.gumtree.user.dao;

import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public interface AddressBookDao {

	long getPersonCountBySex(Sex sex);

	Person getOldestPerson();

	Person getPersonByFirstName(String firstName);
}
