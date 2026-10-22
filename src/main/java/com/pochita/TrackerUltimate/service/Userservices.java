package com.pochita.TrackerUltimate.service;

import com.pochita.TrackerUltimate.entity.User;
import com.pochita.TrackerUltimate.repository.Userrepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class Userservices {

    private final Userrepository userrepository;
    private final PasswordEncoder passwordEncoder;

    public Userservices( Userrepository userrepository, PasswordEncoder passwordEncoder) {
            this.userrepository = userrepository;
            this.passwordEncoder = passwordEncoder;
    }

    public void createUser(User user) {
        String hashedpass = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedpass);
        userrepository.save(user);
    }

    public List<User> getallUsers() {
        return userrepository.findAll();
    }

    public void DeleteUser(User user){
        userrepository.delete(user);
    }

    public User getUserById(Long id){
        return userrepository.findById(id).get();
    }
}
