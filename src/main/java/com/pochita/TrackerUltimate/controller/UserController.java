package com.pochita.TrackerUltimate.controller;


import com.pochita.TrackerUltimate.entity.User;
import com.pochita.TrackerUltimate.service.Userservices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final Userservices userservices;

    public UserController(Userservices userservices){
        this.userservices = userservices;
    }

    @GetMapping
    public List<User> getUsers() {
        return userservices.getallUsers();
    }
    @PostMapping
    public void CreateUser(@RequestBody User user) {
        userservices.createUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user) {
        userservices.DeleteUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userservices.getUserById(id);
    }
}
