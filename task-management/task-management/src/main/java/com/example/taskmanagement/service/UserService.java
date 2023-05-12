package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.LogInDTO;
import com.example.taskmanagement.dto.UserDTO;
import com.example.taskmanagement.responses.LogInResponse;
import com.example.taskmanagement.responses.RegisterResponse;

public interface UserService {
    RegisterResponse addUser(UserDTO userDTO);

    LogInResponse logInUser(LogInDTO logInDTO);
}
