package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.LogInDTO;
import com.example.taskmanagement.dto.UserDTO;
import com.example.taskmanagement.responses.LogInResponse;
import com.example.taskmanagement.responses.RegisterResponse;
import com.example.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// to connect frontend
@CrossOrigin(origins ={ "http://localhost:4200"})
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path="/user-registration")
    public ResponseEntity<RegisterResponse> saveUser(@RequestBody UserDTO userDTO){
        RegisterResponse registerResponse = userService.addUser(userDTO);
        return ResponseEntity.ok(registerResponse);
    }

    @PostMapping(path="/user-login")
    public ResponseEntity<?> logInUser(@RequestBody LogInDTO logInDTO){
        LogInResponse logInResponse = userService.logInUser(logInDTO);
        return ResponseEntity.ok(logInResponse);
    }

}
