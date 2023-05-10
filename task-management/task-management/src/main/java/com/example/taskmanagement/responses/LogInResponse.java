package com.example.taskmanagement.responses;

public class LogInResponse {

    private String response;
    private Boolean status;

    public LogInResponse() {
    }

    public LogInResponse(String response, Boolean status) {
        this.response = response;
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LogInResponse{" +
                "response='" + response + '\'' +
                ", status=" + status +
                '}';
    }
}
