package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.UserDTO;
import com.example.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// to connect frontend
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(path="/save")
    public String saveUser(@RequestBody UserDTO userDTO){
        String id = userService.addUser(userDTO);
        return id;
    }
}
