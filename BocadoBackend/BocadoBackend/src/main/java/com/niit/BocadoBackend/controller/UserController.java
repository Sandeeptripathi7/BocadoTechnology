package com.niit.BocadoBackend.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.niit.BocadoBackend.model.User;

@RestController  
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")


public class UserController {
	@Autowired  
    private User user;
	
	 @PostMapping("/user")  
	    public boolean save(@RequestBody User user) {  
	         return user.save(user);  
	          
	    }
	 @PutMapping("/user")  
	    public boolean update(@RequestBody User user) {  
	         return user.update(user);  
	          
	    }

	 
	 @ResponseBody
	 @RequestMapping(value = "/User", method = RequestMethod.GET)
	    public ResponseEntity<List<User>> list() {
		 List<User> users = user.list();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	    } 

	 

}

