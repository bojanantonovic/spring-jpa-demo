package jpademo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepo extends JpaRepository<Person, Long> {
	//@Query("select p from Person p where p.username like %?1%")
	//Optional<Person> findByUsername(String username);
//	@Query("select p from Person p where p.firstName=:fn and p.lastName=:ln") Optional<Person> findByCompleteName(@Param("fn")String fn,
//																												  @Param("ln")String lastName);
}
