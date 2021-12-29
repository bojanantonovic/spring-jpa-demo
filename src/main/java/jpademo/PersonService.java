package jpademo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

	private final PersonRepo personRepo;

	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}

	@Transactional
	public Person save(final Person person) {
		return personRepo.saveAndFlush(person);
	}

	public Optional<Person> findById(final long id) {
		return personRepo.findById(id);
	}

	public List<Person> findAll() {
		return personRepo.findAll();
	}
}
