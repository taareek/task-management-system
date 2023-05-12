package com.example.taskmanagement.responses;

public class RegisterResponse {
    private String response;
    private Boolean status;

    public RegisterResponse(String response, Boolean status) {
        this.response = response;
        this.status = status;
    }

    public RegisterResponse() {
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
        return "RegisterResponse{" +
                "response='" + response + '\'' +
                ", status=" + status +
                '}';
    }
}
