package com.redis.controller;

import com.redis.model.User;
import com.redis.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserSevice userSevice;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user){
        boolean result = userSevice.saveUser(user);

        if(result)
            return ResponseEntity.ok("User created Successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>>fetchAllUsers(){
        List<User>users;
        users = userSevice.fetchAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User>fetchUserById(@PathVariable("id") Long id){

        User user;
        user =userSevice.fetchUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable("id") Long id){
        boolean deletedUser;
        deletedUser = userSevice.deleteUser(id);
        if(deletedUser)
            return ResponseEntity.ok("User deleted Successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();


    }

}
