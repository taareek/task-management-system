package com.example.taskmanagement.config;

import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepo.findUserByUserName(userName).get();
        return (UserDetails) user;
    }

    public void createUser(UserDetails user) {
        userRepo.save((User) user);}
}
