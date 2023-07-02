package com.example.taskmanagement.serviceImpl;

import com.example.taskmanagement.dto.TaskDTO;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.mapper.TaskMapper;
import com.example.taskmanagement.repo.TaskRepo;
import com.example.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private final TaskRepo taskRepo;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepo taskRepo, TaskMapper taskMapper) {
        this.taskRepo = taskRepo;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDTO addTask(TaskDTO taskDTO) {
        Task task = taskMapper.mapTaskDtoToEntity(taskDTO);
        Task savedTask = taskRepo.save(task);
        return taskMapper.mapTaskEntityToDto(savedTask);
    }

    @Override
    public List<TaskDTO> getAllTask() {
        List<Task> tasks = taskRepo.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
//        is there any way to sort all tasks by date here ?
        return taskMapper.mapTaskEntityListToTaskDtoList(tasks);
    }

    @Override
    public void deleteTask(long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public TaskDTO updateTaskById(long id, TaskDTO taskDTO) {
        Task providedTask = taskRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found for the ID: " + id));

        providedTask.setTaskName(taskDTO.getTaskName());
        providedTask.setDescription(taskDTO.getDescription());
        providedTask.setCreatedAt(taskDTO.getCreatedAt());
        providedTask.setDueDate(taskDTO.getDueDate());
        providedTask.setExpectedTime(taskDTO.getExpectedTime());
        providedTask.setTaskPriorityLevel(taskDTO.getTaskPriorityLevel());
        providedTask.setHasReminder(taskDTO.getHasReminder());
        providedTask.setTaskStatus(taskDTO.getTaskStatus());
        providedTask.setTaskCollection(taskDTO.getTaskCollection());

        Task updatedTask = taskRepo.save(providedTask);
        return taskMapper.mapTaskEntityToDto(updatedTask);
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO) {
//        Task toBeUpdated = taskMapper.mapTaskDtoToEntity(taskDTO);
        long taskId = taskDTO.getId();
        Task toBeUpdated = taskRepo.findById(taskId).
                orElseThrow(() -> new EntityNotFoundException("Task not found"));

        toBeUpdated.setTaskName(taskDTO.getTaskName());
        toBeUpdated.setDescription(taskDTO.getDescription());
        toBeUpdated.setCreatedAt(taskDTO.getCreatedAt());
        toBeUpdated.setDueDate(taskDTO.getDueDate());
        toBeUpdated.setExpectedTime(taskDTO.getExpectedTime());
        toBeUpdated.setTaskPriorityLevel(taskDTO.getTaskPriorityLevel());
        toBeUpdated.setHasReminder(taskDTO.getHasReminder());
        toBeUpdated.setTaskStatus(taskDTO.getTaskStatus());
        toBeUpdated.setTaskCollection(taskDTO.getTaskCollection());
        Task updatedTask = taskRepo.save(toBeUpdated);
        return taskMapper.mapTaskEntityToDto(updatedTask);
    }

    @Override
    public TaskDTO searchTaskById(long id) {
        Task providedTask = taskRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found for the ID: " + id));
        return taskMapper.mapTaskEntityToDto(providedTask);
    }
}
