package fr.epita.EpiiQuiz.controller;

import fr.epita.EpiiQuiz.model.Question;
import fr.epita.EpiiQuiz.model.Users;
import fr.epita.EpiiQuiz.repository.LoginRepo;
import fr.epita.EpiiQuiz.repository.QuestionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {
	
	@Autowired
    QuestionRepo quesRepo;
	
	
	 @GetMapping("/Ques")
	    public List<Question> getAllQues() {
	        return quesRepo.findAll();
	    }

	    @GetMapping("/Ques/{id}")
	    public ResponseEntity<Question> getQuesById(@PathVariable(value = "id") Long quesId) {
	        Question ques = quesRepo.findOne(quesId);
	        if(ques == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(ques);
	    }
	    
	   /* @GetMapping("/Users/{name}")
	    public ResponseEntity<List<Users>> getUsersByName(@PathVariable(value = "name") String UsersId) {
	        System.out.println("entered------------------------");
	    	List<Users> Users = quesRepo.findByName(UsersId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(Users);
	    }

	    @GetMapping("/Users/{name}/{password}")
	    public ResponseEntity<List<Users>> authenticateLogin(@PathVariable(value = "name") String UsersId,@PathVariable(value = "password") String password) {
	        System.out.println("entered------------------------");
	    	List<Users> Users = quesRepo.findLogin(UsersId,password);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(Users);
	    }*/
	    
	    @PostMapping("/Ques")
	    public Question createQues(@Valid @RequestBody Question ques) {
	        return quesRepo.save(ques);
	    }

	    @PutMapping("/Ques/{id}")
	    public ResponseEntity<Question> updateQues(@PathVariable(value = "id") Long UsersId,
	                                           @Valid @RequestBody Question quesDetails) {
	        Question ques = quesRepo.findOne(UsersId);
	        if(ques == null) {
	            return ResponseEntity.notFound().build();
	        }
	        ques.setQuestion(quesDetails.getQuestion());
	        ques.setOption1(quesDetails.getOption1());
	        ques.setOption2(quesDetails.getOption2());
	        ques.setOption3(quesDetails.getOption3());
	        ques.setOption4(quesDetails.getOption4());
	        ques.setAnswer(quesDetails.getAnswer());
	        ques.setExplaination(quesDetails.getExplaination());
	        ques.setTags(quesDetails.getTags());

	        Question updatedUsers = quesRepo.save(ques);
	        return ResponseEntity.ok(updatedUsers);
	    }

	    @DeleteMapping("/Ques/{id}")
	    public ResponseEntity<Question> deleteQues(@PathVariable(value = "id") Long quesId) {
	        Question Users = quesRepo.findOne(quesId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }

	        quesRepo.delete(Users);
	        return ResponseEntity.ok().build();
	    }

}
