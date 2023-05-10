package com.example.taskmanagement.serviceImpl;

import com.example.taskmanagement.dto.LogInDTO;
import com.example.taskmanagement.dto.UserDTO;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.repo.UserRepo;
import com.example.taskmanagement.responses.LogInResponse;
import com.example.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public LogInResponse logInUser(LogInDTO logInDTO){
        String msg= " ";
        User userByEmail = userRepo.findByEmail(logInDTO.getEmail());

        if(userByEmail != null){
            String password = logInDTO.getPassword();
            String encodedPassword = userByEmail.getPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);

            if(isPasswordRight){
                Optional<User> user = userRepo.findOneByEmailAndPassword(logInDTO.getEmail(), encodedPassword);
                if(user.isPresent()){
                    return new LogInResponse("Login Successful!", true);
                }else{
                    return new LogInResponse("Login failed, Please try again!!", false);
                }
            }else{
                return new LogInResponse("Password doesn't match!", false);
            }
        }else{
            return new LogInResponse("Email does not exist!", false);
        }
    }
}
