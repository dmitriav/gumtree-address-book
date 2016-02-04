package com.gumtree.user.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gumtree.user.model.MockPerson;
import com.gumtree.user.model.Person;

public class PersonMapperTest {

	private PersonMapper mapper;


	@Before
	public void setUp() {
		mapper = new PersonMapper();
	}


	@Test
	public void mapPerson() {
		Person person = mapper.apply(" Bill McKnight , Male , 16/03/77");
		Person expectedPerson = MockPerson.getBillMcKnight();
		Assert.assertEquals(expectedPerson, person);
	}

	@Test
	public void mapPersonMissingValues() {
		Person person = null;

		person = mapper.apply("Bill, 16/03/77");
		Assert.assertNull(person);

		person = mapper.apply("  ");
		Assert.assertNull(person);

		person = mapper.apply(",");
		Assert.assertNull(person);

		person = mapper.apply(" ");
		Assert.assertNull(person);

		person = mapper.apply("");
		Assert.assertNull(person);

		person = mapper.apply(null);
		Assert.assertNull(person);
	}

	@Test
	public void mapPersonInvalidSex() {
		Person person = mapper.apply(" Bill McKnight , Mail , 16/03/77");
		Person expectedPerson = MockPerson.getBillMcKnight();
		expectedPerson.setSex(null);
		Assert.assertEquals(expectedPerson, person);
	}

	@Test
	public void mapPersonMissingSex() {
		Person person = mapper.apply(" Bill McKnight ,  , 16/03/77");
		Person expectedPerson = MockPerson.getBillMcKnight();
		expectedPerson.setSex(null);
		Assert.assertEquals(expectedPerson, person);
	}

	@Test
	public void mapPersonInvalidLastName() {
		Person person = mapper.apply(" Bill , Male , 16/03/77");
		Person expectedPerson = MockPerson.getBillMcKnight();
		expectedPerson.setLastName(null);
		Assert.assertEquals(expectedPerson, person);
	}

	@Test
	public void mapPersonEmptyName() {
		Person person = mapper.apply(" , Male , 16/03/77");
		Person expectedPerson = MockPerson.getBillMcKnight();
		expectedPerson.setFirstName(null);
		expectedPerson.setLastName(null);
		Assert.assertEquals(expectedPerson, person);
	}

	@Test
	public void mapPersonInvalidDateOfBirth() {
		Person person = mapper.apply(" Bill McKnight , Male , 1977");
		Person expectedPerson = MockPerson.getBillMcKnight();
		expectedPerson.setDateOfBirth(null);
		Assert.assertEquals(expectedPerson, person);
	}
}
