package telran.java52.student.dao;

import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import telran.java52.student.model.Student;

public interface StudentRepository extends MongoRepository<Student, Long> {

	Stream<Student> getAllBy();

	Stream<Student> findByNameIgnoreCase(String name);
	
	long countByNameIgnoreCaseIn(Iterable<String> names);
	
	@Query("{'scores.?0': {$gte: ?1}}")
	Stream<Student> findByExamAndScoreGreaterThan(String exam, int score);

}
