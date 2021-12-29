package jpademo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(H2Configuration.class)
class TestWithH2 {

	@Autowired
	private PersonService personService;

	@Test
	void test() {
		final var person = new Person(1L, "Donald", "Duck");
		final var savedPerson = personService.save(person);
		assertNotNull(savedPerson.getId());
		assertEquals(savedPerson.getId(), person.getId());

		final var personList = personService.findAll();
		final var personOptional = personService.findById(1L);
		assertTrue(personOptional.isPresent());
		assertEquals(personOptional.get(), person);
	}
}
