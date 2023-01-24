package capstone.authapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import capstone.authapi.Models.AuthenticationModel;
//import capstone.authapi.Repositories.AuthenticationRepo;

@RequestMapping("auth-api")
@RestController
public class Authentication {

    // @Autowired
    // private AuthenticationRepo auth;

    @PostMapping("/login")
    public ResponseEntity Login(@RequestBody AuthenticationModel model) {
        return new ResponseEntity<Object>(model, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity Register(@RequestBody AuthenticationModel model) {
        
        return new ResponseEntity<Object>(model, HttpStatus.OK);
    }

}
