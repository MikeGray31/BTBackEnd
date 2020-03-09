package com.example.demo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long project_id;
    private String title;
    private String description;
    private Date startDate;
    @OneToMany
    private List<Project_User> project_users;
    @OneToMany
    private List<Ticket> tickets;

    public Long getId() {
        return project_id;
    }

    public void setId(Long id) {
        this.project_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<Project_User> getProject_users() {
        return project_users;
    }

    public void setProject_users(List<Project_User> project_users) {
        this.project_users = project_users;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
