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
    private Project_Access project_access;
    @OneToMany(mappedBy = "project")
    private List<Project_User> project_users;
    @OneToMany
    private List<Ticket> tickets;

    private enum Project_Access{
        PUBLIC,
        PRIVATE
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
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

    public Project_Access getProject_access() {
        return project_access;
    }

    public void setProject_access(Project_Access project_access) {
        this.project_access = project_access;
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
