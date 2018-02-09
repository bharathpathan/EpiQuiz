package fr.epita.EpiiQuiz.repository;

import fr.epita.EpiiQuiz.model.Question;
import fr.epita.EpiiQuiz.model.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long>  {

	
	/* @Query(value="SELECT * FROM login p WHERE LOWER(p.name) = LOWER(:name)", nativeQuery = true)
	    public List<Users> findByName(@Param("name") String name);
	 
	 @Query(value="SELECT * FROM login p WHERE LOWER(p.name) = LOWER(:name) AND LOWER(p.password) = LOWER(:password) ", nativeQuery = true)
	    public List<Users> findLogin(@Param("name") String name,@Param("password") String password);*/
	
	
}
