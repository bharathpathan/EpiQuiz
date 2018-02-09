package fr.epita.EpiiQuiz.controller;

import fr.epita.EpiiQuiz.model.Users;
import fr.epita.EpiiQuiz.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
    LoginRepo loginRepo;
	
	
	 @GetMapping("/Userss")
	    public List<Users> getAllUserss() {
	        return loginRepo.findAll();
	    }

	    @GetMapping("/Userss/{id}")
	    public ResponseEntity<Users> getUsersById(@PathVariable(value = "id") Long UsersId) {
	        Users Users = loginRepo.findOne(UsersId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(Users);
	    }
	    
	    @GetMapping("/Users/{name}")
	    public ResponseEntity<List<Users>> getUsersByName(@PathVariable(value = "name") String UsersId) {
	        System.out.println("entered------------------------");
	    	List<Users> Users = loginRepo.findByName(UsersId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(Users);
	    }

	    @GetMapping("/Users/{name}/{password}")
	    public ResponseEntity<List<Users>> authenticateLogin(@PathVariable(value = "name") String UsersId,@PathVariable(value = "password") String password) {
	        System.out.println("entered------------------------");
	    	List<Users> Users = loginRepo.findLogin(UsersId,password);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok().body(Users);
	    }
	    
	    @PostMapping("/Users")
	    public Users createUsers(@Valid @RequestBody Users Users) {
	        return loginRepo.save(Users);
	    }

	    @PutMapping("/Userss/{id}")
	    public ResponseEntity<Users> updateUsers(@PathVariable(value = "id") Long UsersId,
	                                           @Valid @RequestBody Users UsersDetails) {
	        Users Users = loginRepo.findOne(UsersId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }
	        Users.setName(UsersDetails.getName());
	        Users.setPassword(UsersDetails.getPassword());

	        Users updatedUsers = loginRepo.save(Users);
	        return ResponseEntity.ok(updatedUsers);
	    }

	    @DeleteMapping("/Userss/{id}")
	    public ResponseEntity<Users> deleteUsers(@PathVariable(value = "id") Long UsersId) {
	        Users Users = loginRepo.findOne(UsersId);
	        if(Users == null) {
	            return ResponseEntity.notFound().build();
	        }

	        loginRepo.delete(Users);
	        return ResponseEntity.ok().build();
	    }

}
