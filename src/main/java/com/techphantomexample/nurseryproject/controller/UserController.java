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

    @PostMapping
    public ResponseEntity<CreateResponse> createUser(@RequestBody User user) {
        String result = userService.createUser(user);
        HttpStatus httpStatus;
        if (result.equals("User Created successfully")) {
            httpStatus = HttpStatus.CREATED;
        } else if (result.equals("User with provided Email ID exists")) {
            httpStatus = HttpStatus.CONFLICT;
        } else {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        CreateResponse response = new CreateResponse(result, httpStatus.value());
        return ResponseEntity.status(httpStatus).body(response);
    }

    // Read all users in DB
    @GetMapping
    public ResponseEntity<List<User>> getAllUserDetails() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
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

