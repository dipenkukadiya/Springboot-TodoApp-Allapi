package com.example.Coder.Controller;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Coder.DTO.UserDto;
import com.example.Coder.Entity.User;
import com.example.Coder.Service.UserAuthService;

@RestController
@RequestMapping("/api/v1")
public class UserAuthController {

    @Autowired
    UserAuthService userAuthService;

    @PostMapping("/register")
    public void addRegisterUser(@RequestBody User user) {
        userAuthService.addRegisterUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDto userDto) {
        // String token = userAuthService.loginUser(userDto);
        try {
            String token = userAuthService.loginUser(userDto);
            if (token != null) {
                // Authentication successful, return JWT token
                return ResponseEntity.ok(token);
            } else {
                // Authentication failed
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Return a generic error message to the client
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An internal server error occurred");
        }
    }

    // @GetMapping("/getalluser")
    // public List<User> getUsers() {
    // return userAuthService.getUsers();
    // }

    // @GetMapping("/getbyemail/{email}")
    // public User getUserByEmail(@PathVariable String email) {
    // return userAuthService.getUserByemail(email);
    // }
}
