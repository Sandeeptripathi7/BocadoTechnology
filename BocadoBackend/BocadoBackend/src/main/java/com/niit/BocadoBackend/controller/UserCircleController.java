package com.niit.BocadoBackend.controller;

package com.niit.UserBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.niit.BocadoBackend.model.User;

@RestController  
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")  
public class UserCircleController {
	@Autowired  
    private UserCircle usercircle; 
	
	public boolean addUserToCircle(String emailId, String circleName) {
		// TODO Auto-generated method stub
		return usercircle.addUserToCircle(emailId, circleName);
	}

	@DeleteMapping("/Usercircle/{emailId,circleName}")  
    public boolean deleteUserfromCircle(@PathVariable("emailId") String emailId,@PathVariable("circleName") String circleName) {  
        return usercircle.deleteUserfromCircle(emailId,circleName);  
    }  
	@ResponseBody
	@RequestMapping(value = "/UserCircle/{circleName}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getUsersofCircle(@PathVariable("circleName") String circleName) {
        System.out.println("Fetching User with id " + circleName);
        User user = (User) usercircle.getUsersofCircle(circleName);
        if (user == null) {
            System.out.println( circleName + " not found");
            return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<String>>(HttpStatus.OK);
    }
}

