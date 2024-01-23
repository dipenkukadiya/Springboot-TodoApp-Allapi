package com.example.Coder.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Coder.DTO.UserDTO;
import com.example.Coder.Entity.User;
import com.example.Coder.Request.UserRegisterRequest;
import com.example.Coder.Request.UserUpdateRequest;
import com.example.Coder.Request.UserLoginRequest;
import com.example.Coder.Service.UserAuthService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class UserAuthController {

    @Autowired
    UserAuthService userAuthService;

    @PostMapping("/register")
    public void addUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        userAuthService.addUser(userRegisterRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginRequest userLoginRequest) {

        try {
            String token = userAuthService.loginUser(userLoginRequest);
            if (token != null) {

                return ResponseEntity.ok(token);
            } else {

                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An internal server error occurred");
        }
    }

    @GetMapping("/getalluser")
    public List<User> getUsers() {
        return userAuthService.getUsers();
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long user_id) {
        UserDTO userDTO = userAuthService.getUserById(user_id);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/user/{user_id}")
    public ResponseEntity<Void> updateUser(@RequestBody UserUpdateRequest userUpdateRequest,
            @PathVariable Long user_id) {
        System.out.println("hello update controller");
        userAuthService.updateUser(userUpdateRequest, user_id);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("user/{user_id}")
    public ResponseEntity<Void> DeleteUser(@PathVariable Long user_id) {
        userAuthService.removeUser(user_id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-token")
    public ResponseEntity<User> getUserByToken(@RequestParam String token) {
        User user = userAuthService.getByToken(token);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ########## GET ALL USER BY EMAIL #############

    // @GetMapping("/{email}")
    // public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
    // User user = userAuthService.getUserByemail(email);

    // if (user != null) {
    // return new ResponseEntity<>(user, HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }
}
