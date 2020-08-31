package com.niit.BocadoBackend.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.niit.BocadoBackend.model.Message;
import com.niit.BocadoBackend.model.User;

@RestController  
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")

public class MessageController {
	@Autowired  
    private Message message;  
	@PostMapping("/message")  
    public boolean sendMessage(@RequestBody Message message) {  
         return message.sendMessage(message);  
          
    }  
	@ResponseBody
	@RequestMapping(value = "/Message/{emailId}", method = RequestMethod.GET)
    public ResponseEntity<List<Message>> getUser(@PathVariable("emailId") String emailId) {
        System.out.println("Fetching User with id " + emailId);
        User user = (User) message.getMyMessages(emailId);
        if (user == null) {
            System.out.println("User with id " + emailId + " not found");
            return new ResponseEntity<List<Message>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Message>>(HttpStatus.OK);
    }
	
}

