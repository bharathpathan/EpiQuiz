package fr.epita.EpiiQuiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.epita.EpiiQuiz.model.Quiz;


@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long>  {

}
