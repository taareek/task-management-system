package com.example.taskmanagement.serviceImpl;

import com.example.taskmanagement.dto.TaskCollectionDTO;
import com.example.taskmanagement.entity.TaskCollection;
import com.example.taskmanagement.mapper.TaskCollectionMapper;
import com.example.taskmanagement.repo.TaskCollectionRepo;
import com.example.taskmanagement.service.TaskCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskCollectionServiceImpl implements TaskCollectionService {

    @Autowired
    private final TaskCollectionRepo taskCollectionRepo;
    private final TaskCollectionMapper taskCollectionMapper;
    public TaskCollectionServiceImpl(TaskCollectionRepo taskCollectionRepo, TaskCollectionMapper taskCollectionMapper) {
        this.taskCollectionRepo = taskCollectionRepo;
        this.taskCollectionMapper = taskCollectionMapper;
    }

    @Override
    public TaskCollectionDTO addTaskCollection(TaskCollectionDTO taskCollectionDTO){

        TaskCollection taskCollection = taskCollectionMapper.mapTaskCollectionDtoToEntity(taskCollectionDTO);
        TaskCollection savedTaskCollection = taskCollectionRepo.save(taskCollection);
        return taskCollectionMapper.mapTaskCollectionEntityToDto(savedTaskCollection);
    }

    @Override
    public List<TaskCollectionDTO> getAllTaskCollection(){
        List<TaskCollection> taskCollections = taskCollectionRepo.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        return taskCollections.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TaskCollectionDTO convertToDTO(TaskCollection taskCollection) {
        TaskCollectionDTO dto = new TaskCollectionDTO();
        dto.setId(taskCollection.getId());
        dto.setTaskCollectionName(taskCollection.getTaskCollectionName());
        // Set other properties as needed
        return dto;
    }

    @Override
    public void deleteTaskCollection(long id) {
        taskCollectionRepo.deleteById(id);
    }

    @Override
    public TaskCollection updateTaskCollection(TaskCollection taskCollection) {
        return taskCollectionRepo.save(taskCollection);
    }

    @Override
    public TaskCollection searchTaskCollectionById(long id) {
        return taskCollectionRepo.findById(id).get();
    }

}
