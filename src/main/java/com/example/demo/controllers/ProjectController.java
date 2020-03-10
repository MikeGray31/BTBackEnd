package com.example.demo.controllers;

import com.example.demo.models.Project;
import com.example.demo.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProjectController {

    private ProjectServices projectServices;

    @Autowired
    public ProjectController(ProjectServices projectServices) {
        this.projectServices = projectServices;
    }

    @PostMapping("/project/create")
    public ResponseEntity<Project> createProject(@RequestBody Project newProject) {
        return new ResponseEntity<>(this.projectServices.createProject(newProject), HttpStatus.CREATED);
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Project> findProject(@PathVariable Long id) {
        return new ResponseEntity<>(this.projectServices.findProject(id), HttpStatus.OK);
    }

    @PutMapping("/project/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project newInfo){
        return new ResponseEntity<>(this.projectServices.updateProject(id, newInfo), HttpStatus.OK);
    }

    @DeleteMapping("/project/delete/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable Long id){
        return new ResponseEntity(this.projectServices.deleteProject(id), HttpStatus.OK);
    }
}
