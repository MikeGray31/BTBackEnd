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

    private enum user_status{
        ADMIN,
        CONTRIBUTOR
    }
}
