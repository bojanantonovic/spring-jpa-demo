package jpademo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
class PersonService {

	private final PersonRepo personRepo;

	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}

	Person save(final Person person) {
		return personRepo.save(person);
	}

	Optional<Person> findById(final long id) {
		return personRepo.findById(id);
	}

	List<Person> findAll() {
		return personRepo.findAll();
	}
}
