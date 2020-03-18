package com.example.demo.services;

import com.example.demo.models.Project;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    private UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User newUser){
        return this.userRepository.save(newUser);
    }

    public User getUserById(Long id){
        return this.userRepository.findById(id).get();
    }

    public User updateUser(Long id, User newInfo){
        if(this.userRepository.findById(id).isPresent()) {
            newInfo.setUser_id(id);
            return this.userRepository.save(newInfo);
        }
        return null;
    }

    public Boolean deleteUser(Long id){
        if(this.userRepository.existsById(id)) {
            this.userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
