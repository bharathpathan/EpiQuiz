package fr.epita.EpiiQuiz.repository;

import fr.epita.EpiiQuiz.model.Student;
import fr.epita.EpiiQuiz.model.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*
 * 
 * Repository for Student
 * a repository doest need methods as the JPA Repository class provides it internally
 */
@Repository
public interface StudentRepo extends JpaRepository<Student, Long>  {

	

}
