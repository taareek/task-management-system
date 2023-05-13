package com.example.taskmanagement.repo;

import com.example.taskmanagement.entity.TaskCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCollectionRepo extends JpaRepository<TaskCollection, Long> {
}
