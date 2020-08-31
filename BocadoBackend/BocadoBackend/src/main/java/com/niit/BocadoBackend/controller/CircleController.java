package com.niit.BocadoBackend.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.niit.BocadoBackend.model.Circle;
import com.niit.BocadoBackend.model.User;



@RestController  
@CrossOrigin(origins="http://localhost:4200")  
@RequestMapping(value="/api")  
public class CircleController {

	@Autowired  
    private Circle circle;  
      
    @PostMapping("/circle")  
    public boolean addCircle(@RequestBody Circle circle) {  
         return circle.addCircle(circle);  
          
    }  
      
    @GetMapping("/circle")  
    public List<Circle> getAllCircles() {  
         return circle.getAllCircles();  
          
    }  
      
    @DeleteMapping("circle/{emailId,circleName}")  
    public boolean deleteCircle(@PathVariable("emailId") String emailId,@PathVariable("circleName") String circleName) {  
        return circle.deleteCircle(emailId,circleName);  
    }  
    
    @ResponseBody
    @RequestMapping(value = "/Circle/{emailId}", method = RequestMethod.GET)
    public ResponseEntity<List<Circle>> getUser(@PathVariable("emailId") String emailId) {
        System.out.println("Fetching User with id " + emailId);
        User user = (User) circle.getCircleByUser(emailId);
        if (user == null) {
            System.out.println("User with id " + emailId + " not found");
            return new ResponseEntity<List<Circle>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Circle>>(HttpStatus.OK);
    }
    @ResponseBody  
    @RequestMapping(value = "/Circle/", method = RequestMethod.GET)
    public ResponseEntity<List<Circle>> listAllUsers() {
        List<Circle> users = circle.getAllCircles();
        if(users.isEmpty()){
            return new ResponseEntity<List<Circle>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Circle>>(users, HttpStatus.OK);
    } 
    
    
    
}

