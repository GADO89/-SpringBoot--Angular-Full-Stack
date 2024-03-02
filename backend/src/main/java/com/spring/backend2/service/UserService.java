package com.spring.backend2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.backend2.entity.User;
import com.spring.backend2.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User  createUser(User user){
        return userRepository.save(user);
    }
    public User  getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public User  updateUser(User user1){
        return userRepository.save(user1);
    }
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
   public void deleteUser(User user){
         userRepository.delete(user);
   }
}
