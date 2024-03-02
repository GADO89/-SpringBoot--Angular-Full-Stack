package com.spring.backend2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.backend2.entity.User;
import com.spring.backend2.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user=new User();
        if (user ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( userService.getUserById(id));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User>  updateUser(@RequestBody User user,@PathVariable Long id){
        User user1=userService.getUserById(id);
        if (user1 ==null){
            return ResponseEntity.notFound().build();
        }
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        User updateUser=userService.updateUser(user1);
        return ResponseEntity.ok(updateUser);
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null)
            return ResponseEntity.notFound().build();
            userService.deleteUser(user);
            return ResponseEntity.ok().build();

        }


}
