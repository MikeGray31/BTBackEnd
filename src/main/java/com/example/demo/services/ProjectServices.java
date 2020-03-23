package com.example.demo.services;

import com.example.demo.models.Project;
import com.example.demo.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServices {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServices(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
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

    public void addMember() {

    }
}
