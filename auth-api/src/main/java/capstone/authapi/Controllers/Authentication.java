package capstone.authapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import capstone.authapi.Models.AuthenticationModel;
import capstone.authapi.Models.ResponseModel;
import capstone.authapi.Repositories.AuthenticationRepository;

@CrossOrigin
@RequestMapping("auth-api")
@RestController
public class Authentication {

    @Autowired
    private AuthenticationRepository auth;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity Login(@RequestBody AuthenticationModel model) {

        ResponseModel message = new ResponseModel();

        String username = model.getUsername();
        String password = model.getPassword();
        AuthenticationModel UserData = auth.findByUsername(username);

        if (UserData == null) {
            message.setMessage("Wrong Credentials");
            return new ResponseEntity<Object>(message, HttpStatus.OK);

        }

        if (UserData.getUsername().equals(username) && encoder.matches(password, UserData.getPassword())) {
            message.setMessage("Login Successful");
            return new ResponseEntity<Object>(message, HttpStatus.OK);

        }

        else {
            message.setMessage("Wrong Credentials");
            return new ResponseEntity<Object>(message, HttpStatus.OK);

        }

    }

    @PostMapping("/register")
    public ResponseEntity Register(@RequestBody AuthenticationModel model) {

        ResponseModel message = new ResponseModel();

        String username = model.getUsername();
        String email = model.getEmail();

        AuthenticationModel Username = auth.findByUsername(username);
        AuthenticationModel Email = auth.findByEmail(email);

        if (Username == null) {

            if (Email == null) {

                model.setPassword(encoder.encode(model.getPassword()));
                auth.save(model);
                message.setMessage("Account Created Successfully");
                return new ResponseEntity<Object>(message, HttpStatus.OK);
            }

            else {
                message.setMessage("Email already taken");
                return new ResponseEntity<Object>(message, HttpStatus.OK);

            }

        }

        else {

            message.setMessage("Username already taken");
            return new ResponseEntity<Object>(message, HttpStatus.OK);

        }
    }
}