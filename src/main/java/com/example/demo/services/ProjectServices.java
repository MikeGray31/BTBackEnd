package com.example.demo.services;

import com.example.demo.dtos.ProjectMemberRequest;
import com.example.demo.models.Project;
import com.example.demo.models.Project_User;
import com.example.demo.models.User;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServices {

    private ProjectRepository projectRepository;
    private UserRepository userRepository;

    @Autowired
    public ProjectServices(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public Project createProject(Project newProject) {
       return this.projectRepository.save(newProject);
    }

    public Project findProject(Long id) {
        return this.projectRepository.findById(id).get();
    }

    public Project updateProject(Long id, Project newInfo) {
        if(this.projectRepository.findById(id).isPresent()) {
            newInfo.setProject_id(id);
            return this.projectRepository.save(newInfo);
        }
        return null;
    }

    public Boolean deleteProject(Long id) {
        if(this.projectRepository.existsById(id)){
            this.projectRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void addMember(ProjectMemberRequest newMemberInfo) {
        Project_User newMember = new Project_User();
        newMember.setUser(this.userRepository.findById(newMemberInfo.getUserId()).get());
        newMember.setProject(this.projectRepository.findById(newMemberInfo.getProjectId()).get());
        if(newMemberInfo.getStatus().equals("ADMIN")) newMember.setUser_type(Project_User.user_status.ADMIN);
        else newMember.setUser_type(Project_User.user_status.CONTRIBUTOR);

        Project addToThis = this.projectRepository.findById(newMemberInfo.getProjectId()).get();
        User addThisPerson = this.userRepository.findById(newMemberInfo.getUserId()).get();

        addToThis.addProjectUser(newMember);
        this.projectRepository.save(addToThis);

        addThisPerson.addProjectUser(newMember);
        this.userRepository.save(addThisPerson);
    }
}
