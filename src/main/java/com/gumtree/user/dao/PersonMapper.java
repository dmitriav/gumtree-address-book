package com.gumtree.user.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gumtree.user.model.Person;
import com.gumtree.user.model.Sex;

/**
 * @author Dmitri Avdejev
 * @since 04/02/2016
 */
public class PersonMapper implements Function<String, Person> {

	private static final DateTimeFormatter DATE_OF_BIRTH_FORMATTER 
			= DateTimeFormatter.ofPattern("dd/MM/yy");

	private static Logger logger = LoggerFactory.getLogger(PersonMapper.class);


	@Override
	public Person apply(String line) {
		if (line == null) {
			return null;
		}

		String [] values = line.split(",");
		if (values == null || values.length != 3) {
			logger.warn("Can't map a person from [{}]", line);
			return null;
		}

		Person person = new Person();

		String name = values[0];
		setFullName(person, name);

		String sex = values[1];
		setSex(person, sex);

		String dateOfBirth = values[2];
		setDateOfBirth(person, dateOfBirth);

		return person;
	}

	private void setFullName(Person person, String value) {
		if (person == null || value == null) {
			return;
		}

		value = value.trim();
		if (value.isEmpty()) {
			return;
		}

		String [] values = value.split(" ");
		if (values == null) {
			return;
		}

		int length = values.length;
		String firstName = null;
		String lastName = null;

		if (length > 0) {
			firstName = values[0];
		}

		if (length > 1) {
			lastName = values[1];
		}

		if (firstName != null) {
			firstName = firstName.trim();
		}

		if (lastName != null) {
			lastName = lastName.trim();
		}

		person.setFirstName(firstName);
		person.setLastName(lastName);
	}

	private void setSex(Person person, String value) {
		if (person == null || value == null) {
			return;
		}

		value = value.trim();
		value = value.toUpperCase();

		try {
			Sex sex = Sex.valueOf(value);
			person.setSex(sex);
		} catch (Exception exception) {
			logger.warn("Can't map sex from [{}]", value);
		}
	}

	private void setDateOfBirth(Person person, String value) {
		if (person == null || value == null) {
			return;
		}

		value = value.trim();

		try {
			LocalDate date = LocalDate.parse(value, DATE_OF_BIRTH_FORMATTER);
			date = date.minusYears(100);
			person.setDateOfBirth(date);
		} catch (Exception exception) {
			logger.warn("Can't map date of birth from [{}]", value);
		}
	}
}
