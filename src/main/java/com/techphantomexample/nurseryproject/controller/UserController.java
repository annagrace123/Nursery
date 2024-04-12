package com.techphantomexample.nurseryproject.controller;

import com.techphantomexample.nurseryproject.model.User;
import com.techphantomexample.nurseryproject.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Read specific user
    @GetMapping("{userId}")
    public ResponseEntity<User> getUserDetails(@PathVariable("userId") int userId) {
        User user = userService.getUser(userId);
        if (user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Read all users in DB
    @GetMapping
    public ResponseEntity<List<User>> getAllUserDetails() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity<String> createUserDetails(@RequestBody User user) {
        //userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @PutMapping("{userId}")
    public ResponseEntity<String> updateUserDetails(@PathVariable("userId") int userId, @RequestBody User user) {
        boolean updated = userService.updateUser(userId, user);
        if (updated) {
            return ResponseEntity.ok().body("User Update Successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<String> deleteUserDetails(@PathVariable("userId") int userId) {
        boolean deleted = userService.deleteUser(userId);
        if (deleted) {
            return ResponseEntity.ok().body("User Deleted Successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
