package com.example.taskmanagement.serviceImpl;

import com.example.taskmanagement.dto.UserDTO;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.repo.UserRepo;
import com.example.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String addUser(UserDTO userDTO) {

        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastname(),
                userDTO.getAddress(),
                userDTO.getUserName(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getUserDesignation()
        );

        userRepo.save(user);
        return user.getUserName();
    }
}
