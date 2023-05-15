package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.TaskCollectionDTO;
import com.example.taskmanagement.entity.TaskCollection;
import com.example.taskmanagement.service.TaskCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("api/task-collection")
public class TaskCollectionController {
    @Autowired
    private TaskCollectionService taskCollectionService;

    @PostMapping(path= "/create")
    public TaskCollectionDTO createTaskCollection(@RequestBody TaskCollectionDTO taskCollectionDTO){
        TaskCollectionDTO taskCollection = taskCollectionService.addTaskCollection(taskCollectionDTO);
        return taskCollection;
    }

    @GetMapping(path = "/all-task_collections")
    public List<TaskCollection> getAllTaskCollection(){
        return taskCollectionService.getAllTaskCollection();
    }

    @GetMapping(path = "/task-collection-id/{id}")
    public TaskCollection searchTaskCollection(@PathVariable("id") long id){
        return taskCollectionService.searchTaskCollectionById(id);
    }

    @PutMapping("/edit")
    public TaskCollection editTaskCollection(@RequestBody TaskCollection taskCollection){
        return taskCollectionService.updateTaskCollection(taskCollection);
    }

    @DeleteMapping("/delete/{task_collection_id}")
    public void deleteTaskCollection(@PathVariable("task_collection_id") long id){
        taskCollectionService.deleteTaskCollection(id);
    }
}
