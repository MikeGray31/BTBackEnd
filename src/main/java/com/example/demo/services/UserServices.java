package com.example.demo.services;

import com.example.demo.models.Project;
import com.example.demo.models.Project_User;
import com.example.demo.models.User;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {

    private UserRepository userRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public UserServices(UserRepository userRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
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

    public List<User> getProjectMembers(Long projectId) {
        List<User> project_users = new ArrayList<>();
        for(Project_User pu : this.projectRepository.findById(projectId).get().getProject_users()) {
            project_users.add(pu.getUser());
        }
        return project_users;
    }
}
