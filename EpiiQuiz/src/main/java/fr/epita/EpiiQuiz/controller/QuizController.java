package fr.epita.EpiiQuiz.controller;

import fr.epita.EpiiQuiz.model.Quiz;
import fr.epita.EpiiQuiz.model.Users;
import fr.epita.EpiiQuiz.repository.LoginRepo;
import fr.epita.EpiiQuiz.repository.QuizRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.List;

/*
 * this class is the quiz controller class for rest api services
 */
@RestController
@RequestMapping("/api")
public class QuizController {
	
	@Autowired
    QuizRepo quizRepo;
	
	/*
	 * this method allows to get all quiz
	 * @params - no params
	 * return List of all quizs
	 */
	 @GetMapping("/Quiz")
	    public List<Quiz> getAllUserss() {
	        return quizRepo.findAll();
	    }
	 
	 /*
	  * 
	  * this method returns a specific quiz by providing the ID
	  * @params - QuizID
	  */
	    @GetMapping("/Quiz/{id}")
	    public ResponseEntity<Quiz> getQuizById(@PathVariable(value = "id") Long quizId) {
	        Quiz Users = quizRepo.findOne(quizId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(Users);
	    }
	    
	   /* @GetMapping("/Users/{name}")
	    public ResponseEntity<List<Quiz>> getUsersByName(@PathVariable(value = "qname") String qname) {
	        System.out.println("entered------------------------");
	    	List<Quiz> quiz = quizRepo.findByName(qname);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(quiz);
	    }*/

	/*    @GetMapping("/Users/{name}/{password}")
	    public ResponseEntity<List<Users>> authenticateLogin(@PathVariable(value = "name") String UsersId,@PathVariable(value = "password") String password) {
	        System.out.println("entered------------------------");
	    	List<Users> Users = quizRepo.findLogin(UsersId,password);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(Users);
	    }*/
	    
	    /*
		  * 
		  * this method saves/creates a new quiz.
		  * @params - Quiz object
		  */
	    @PostMapping("/Quiz")
	    public Quiz createUsers(@Valid @RequestBody Quiz quiz) {
	        return quizRepo.save(quiz);
	    }
	    
	    /*
		  * 
		  * this method updates an Existing question.
		  * @params - Quiz Id
		  */
	    @PutMapping("/Quiz/{id}")
	    public ResponseEntity<Quiz> updateUsers(@PathVariable(value = "id") Long UsersId,
	                                           @Valid @RequestBody Quiz UsersDetails) {
	        Quiz Users = quizRepo.findOne(UsersId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        Users.setqName(UsersDetails.getqName());
	        Users.setId(UsersDetails.getId());
	        Users.setqMarks(UsersDetails.getqMarks());
	        Users.setQuesIds(UsersDetails.getQuesIds());

	        Quiz updatedUsers = quizRepo.save(Users);
	        return ResponseEntity.ok(updatedUsers);
	    }

	    /*
		  * 
		  * this method deletes an existing Quiz.
		  * @params - Quiz object
		  */
	    @DeleteMapping("/Quiz/{id}")
	    public ResponseEntity<Quiz> deleteUsers(@PathVariable(value = "id") Long UsersId) {
	        Quiz Users = quizRepo.findOne(UsersId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }

	        quizRepo.delete(Users);
	        return ResponseEntity.ok().build();
	    }

}
