package com.example.contactmanagerh2spring.service;

import com.example.contactmanagerh2spring.model.User;
import com.example.contactmanagerh2spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        try{
            return userRepository.save(user);
        }
        catch (Exception e){
//            logger.error("Error while creating new contact", e);
            return null;
        }
    }

    public boolean validateUser(User user){
        try{
            String username = user.getUsername();
            String password = user.getPassword();

            User storedUser = userRepository.findByUsername(username);

            if (storedUser != null && storedUser.getPassword().equals(password)) {
                return true;
            }

            return false;
        }
        catch (Exception e){
//            logger.error("Error while creating new contact", e);
            return false;
        }
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
