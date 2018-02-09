package fr.epita.EpiiQuiz.controller;

import fr.epita.EpiiQuiz.model.Student;

import fr.epita.EpiiQuiz.repository.LoginRepo;
import fr.epita.EpiiQuiz.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
    StudentRepo loginRepo;
	
	
	 @GetMapping("/Stud")
	    public List<Student> getAllUserss() {
	        return loginRepo.findAll();
	    }

	    @GetMapping("/Stud/{id}")
	    public ResponseEntity<Student> getUsersById(@PathVariable(value = "id") Long UsersId) {
	    	Student Users = loginRepo.findOne(UsersId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(Users);
	    }
	    
	   /* @GetMapping("/Users/{name}")
	    public ResponseEntity<List<Users>> getUsersByName(@PathVariable(value = "name") String UsersId) {
	        System.out.println("entered------------------------");
	    	List<Users> Users = loginRepo.findByName(UsersId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(Users);
	    }*/

	   /* @GetMapping("/Users/{name}/{password}")
	    public ResponseEntity<List<Users>> authenticateLogin(@PathVariable(value = "name") String UsersId,@PathVariable(value = "password") String password) {
	        System.out.println("entered------------------------");
	    	List<Users> Users = loginRepo.findLogin(UsersId,password);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(Users);
	    }*/
	    
	    @PostMapping("/Stud")
	    public Student createUsers(@Valid @RequestBody Student Users) {
	        return loginRepo.save(Users);
	    }

	    @PutMapping("/Stud/{id}")
	    public ResponseEntity<Student> updateUsers(@PathVariable(value = "id") Long UsersId,
	                                           @Valid @RequestBody Student UsersDetails) {
	    	Student Users = loginRepo.findOne(UsersId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        Users.setName(UsersDetails.getName());
	        
	       Users.setQuizids(UsersDetails.getQuizids());
	       Users.setNoofQuiz(UsersDetails.getNoofQuiz());
	       Users.setScore(UsersDetails.getScore());
	        

	        Student updatedUsers = loginRepo.save(Users);
	        return ResponseEntity.ok(updatedUsers);
	    }

	    @DeleteMapping("/Stud/{id}")
	    public ResponseEntity<Student> deleteUsers(@PathVariable(value = "id") Long UsersId) {
	        Student Users = loginRepo.findOne(UsersId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }

	        loginRepo.delete(Users);
	        return ResponseEntity.ok().build();
	    }

}
