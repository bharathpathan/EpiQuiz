package fr.epita.EpiiQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.epita.EpiiQuiz.model.Quiz;

/*
 * 
 * Repository for Quiz
 * a repository doest need methods as the JPA Repository class provides it internally
 */
@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>  {

}
