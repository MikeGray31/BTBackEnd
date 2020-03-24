package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Project_User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private user_status user_type;

    public enum user_status {
        CREATOR,
        ADMIN,
        CONTRIBUTOR
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public user_status getUser_type() {
        return user_type;
    }

    public void setUser_type(user_status user_type) {
        this.user_type = user_type;
    }
}
