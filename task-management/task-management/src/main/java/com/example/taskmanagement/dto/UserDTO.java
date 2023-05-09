package com.example.taskmanagement.dto;

import com.example.taskmanagement.enums.UserDesignation;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserDTO {
    private Long id;
    private String firstName;
    private String lastname;
    private String address;
    private String userName;
    private String email;
    private String password;
    private UserDesignation userDesignation;

    public UserDTO(Long id, String firstName, String lastname, String address, String userName, String email, String password, UserDesignation userDesignation) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.address = address;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userDesignation = userDesignation;
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDesignation getUserDesignation() {
        return userDesignation;
    }

    public void setUserDesignation(UserDesignation userDesignation) {
        this.userDesignation = userDesignation;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userDesignation=" + userDesignation +
                '}';
    }
}
