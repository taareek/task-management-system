package com.example.taskmanagement.repo;

import com.example.taskmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByUserName(String userName);
    Optional<User> findOneByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
