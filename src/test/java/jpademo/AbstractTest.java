package jpademo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractTest {

	@Autowired
	private PersonService personService;

	private Person person;
	private Person savedPerson;

	@BeforeEach
	void init() {
		person = new Person(1L, "Donald", "Duck");
		savedPerson = personService.save(person);
	}

	@Test
	void testSavedPerson() {
		// assert
		assertNotNull(savedPerson.getId());
		assertEquals(savedPerson.getId(), person.getId());
	}

	@Test
	void testFindById() {
		// act
		final var personOptional = personService.findById(1L);

		// assert
		assertTrue(personOptional.isPresent());
		final var foundPerson = personOptional.get();
		assertEquals(foundPerson.getId(), person.getId());
		assertEquals(foundPerson.getFirstName(), person.getFirstName());
		assertEquals(foundPerson.getLastName(), person.getLastName());
	}

	@Test
	void testFindAll() {
		// act
		final var personList = personService.findAll();

		// assert
		assertEquals(personList.size(), 1);
	}
}
