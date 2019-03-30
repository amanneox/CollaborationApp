package com.collaborate.app.collaborateApp.controller;

import com.collaborate.app.collaborateApp.exception.ResourceNotFoundException;
import com.collaborate.app.collaborateApp.model.TaskModel;
import com.collaborate.app.collaborateApp.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @GetMapping("/task")
    public Page<TaskModel> getTasks(Pageable pageable) {
        return taskRepo.findAll(pageable);
    }


    @GetMapping("/task/{taskId}")
    public Optional<TaskModel> getTaskById(@PathVariable Long taskId) {
        return taskRepo.findById(taskId);
    }

    @PostMapping("/task")
    public TaskModel createTask(@Valid @RequestBody TaskModel task) {
        return taskRepo.save(task);
    }

    @PostMapping("/task/update/{taskId}")
    public TaskModel updateTask(@PathVariable Long taskId,
                                @Valid @RequestBody TaskModel userRequest) {
        return taskRepo.findById(taskId)
                .map(task -> {
                    task.setName(userRequest.getName());
                    task.setDescription(userRequest.getDescription());
                    task.setUsers(userRequest.getUsers());
                    return taskRepo.save(task);
                }).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId));
    }


    @PostMapping("/task/delete/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        return taskRepo.findById(taskId)
                .map(task -> {
                    taskRepo.delete(task);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId));
    }

}
