package com.gumtree.user.dao;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

public class FileAddressBookDao implements AddressBookDao {

	private static Logger logger = LoggerFactory.getLogger(
			FileAddressBookDao.class);

	private String fileName;
	private List<Person> contacts;


	private synchronized List<Person> getContacts() {
		if (contacts != null) {
			return contacts;
		}

		try {
			Path path = Paths.get(fileName);
			BufferedReader reader = Files.newBufferedReader(path);
			Stream<String> stream = reader.lines();

			Function<String, Person> mapper = new PersonMapper();
			Predicate<Person> nonNullPredicate = Objects::nonNull;

			contacts = stream.map(mapper).filter(nonNullPredicate)
					.collect(Collectors.toList());

			if (contacts == null) {
				contacts = new ArrayList<>();
			}

			int count = contacts.size();
			logger.debug("Address book loaded with {} contact(s)", count);
		} catch (Exception exception) {
			logger.error("Can't read an address book", exception);
		}

		return contacts;
	}


	@Override
	public long getPersonCountBySex(Sex sex) {
		List<Person> contacts = getContacts();
		if (contacts == null || sex == null) {
			return 0;
		}

		Predicate<Person> nonNullPredicate = Objects::nonNull;
		Predicate<Person> sexPredicate = person -> person.getSex() == sex;
		Predicate<Person> fullPredicate = nonNullPredicate.and(sexPredicate);

		long count = contacts.stream().filter(fullPredicate).count();
		logger.debug("Address book has {} {}(s)", count, sex);

		return count;
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
