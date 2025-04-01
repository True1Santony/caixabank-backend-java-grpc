package io.nuwe.technical.api.controllers;

import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.services.*;
import io.nuwe.technical.api.grpc.GrpcClientService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	/* TODO TASK 1: complete the methods */

    @Autowired
    private UserService userService;

    @Autowired
    private GrpcClientService grpcClientService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
       try{
           User userDev = userService.createUser(user);
          return new ResponseEntity<>(HttpStatus.CREATED);
       } catch (IllegalArgumentException e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

   @DeleteMapping("/user/all")
   public ResponseEntity<String> deleteAllUsers(){
        userService.deleteAll();
       return new ResponseEntity<>(HttpStatus.OK);
   }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnexpectedException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("An unexpected error occurred: " + ex.getMessage());
    }
}
