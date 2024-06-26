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

    @PutMapping("{userId}")
    public ResponseEntity<CreateResponse> updateUserDetails(@PathVariable("userId") int userId, @RequestBody User user) {
        String result = userService.updateUser(userId, user);
        HttpStatus httpStatus;
        if (result.equals("User Updated Successfully")) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        CreateResponse response = new CreateResponse(result, httpStatus.value());
        return ResponseEntity.status(httpStatus).body(response);
    }



    @DeleteMapping("{userId}")
    public ResponseEntity<CreateResponse> deleteUserDetails(@PathVariable("userId") int userId) {
        String result = userService.deleteUser(userId);
        HttpStatus httpStatus;
        if (result.equals("User Deleted Successfully")) {
            httpStatus = HttpStatus.OK;
        } else {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        CreateResponse response = new CreateResponse(result, httpStatus.value());
        return ResponseEntity.status(httpStatus).body(response);
    }
}

