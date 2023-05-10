package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.LogInDTO;
import com.example.taskmanagement.dto.UserDTO;
import com.example.taskmanagement.responses.LogInResponse;
import com.example.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
// to connect frontend
@CrossOrigin
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path="/user-registration")
    public String saveUser(@RequestBody UserDTO userDTO){
        String id = userService.addUser(userDTO);
        return id;
    }

    @PostMapping(path="/user-login")
    public ResponseEntity<?> logInUser(@RequestBody LogInDTO logInDTO){
        LogInResponse logInResponse = userService.logInUser(logInDTO);
        return ResponseEntity.ok(logInResponse);
    }

}
