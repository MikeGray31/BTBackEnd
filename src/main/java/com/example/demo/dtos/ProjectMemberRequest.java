package com.example.demo.dtos;

public class ProjectMemberRequest {

    private Long userId;
    private String userName;
    private String status;
    private Long projectId;
    private String projectTitle;

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getStatus() {
        return status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }
}
