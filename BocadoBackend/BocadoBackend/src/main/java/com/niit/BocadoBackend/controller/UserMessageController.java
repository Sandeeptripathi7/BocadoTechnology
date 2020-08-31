package com.niit.BocadoBackend.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.niit.BocadoBackend.model.Circle;
import com.niit.BocadoBackend.model.User;
import com.niit.BocadoBackend.model.UserMessage;

@RestController  
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")  
public class UserMessageController {
	@Autowired  
    private UserMessage usermessage; 
	
	@PostMapping("/Usermessage")  
    public boolean sendMessage(@RequestBody UserMessage usermessage) {  
         return usermessage.sendMessage(usermessage);  
          
    }  
	
	 @DeleteMapping("/deletestudent/{student_id}")  
	    public boolean deleteMessage(@PathVariable("messageId") int messageId,UserMessage usermessage) {  
		 usermessage.setMessageId(messageId);  
	        return usermessage.deleteMessage(messageId);  
	    } 
	 @ResponseBody
	 @RequestMapping(value = "/UserMessage/{emailId}", method = RequestMethod.GET)
	    public ResponseEntity<List<UserMessage>> getMyMessages(@PathVariable("emailId") String emailId) {
	        System.out.println("Fetching User with id " + emailId);
	        User user = (User) usermessage.getMyMessages(emailId);
	        if (user == null) {
	            System.out.println( emailId + " not found");
	            return new ResponseEntity<List<UserMessage>>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<List<UserMessage>>(HttpStatus.OK);
	    }
	 @ResponseBody
	 @RequestMapping(value = "/UserMessage/{circleName}", method = RequestMethod.GET)
	    public ResponseEntity<List<UserMessage>> getAllMessageByCircleName(@PathVariable("circleName") String circleName) {
	        System.out.println("Fetching User with id " + circleName);
	        User user = (User) usermessage.getAllMessageByCircleName(circleName);
	        if (user == null) {
	            System.out.println( circleName + " not found");
	            return new ResponseEntity<List<UserMessage>>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<List<UserMessage>>(HttpStatus.OK);
	    }
	
	 @ResponseBody
	  @RequestMapping(value = "/UserMessage/{senderEmailId,receiverEmailId}", method = RequestMethod.GET)
	    public ResponseEntity<List<Circle>> getAllMessageByUser(@PathVariable("senderEmailId") String senderEmailId, @PathVariable("receiverEmailId") String receiverEmailId) {
	        System.out.println("Fetching User  " + senderEmailId);
	        User user = (User) usermessage.getAllMessageByUser(senderEmailId,receiverEmailId);
	        if (user == null) {
	            System.out.println("User with id " + senderEmailId + " not found");
	            return new ResponseEntity<List<Circle>>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<List<Circle>>(HttpStatus.OK);
	    }
}

	 


