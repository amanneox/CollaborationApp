package com.collaborate.app.collaborateApp.controller;

import com.collaborate.app.collaborateApp.exception.ResourceNotFoundException;
import com.collaborate.app.collaborateApp.model.ProjectModel;
import com.collaborate.app.collaborateApp.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {
    @Autowired
    private ProjectRepo projectRepo;

    @GetMapping("/project")
    public Page<ProjectModel> getProjects(Pageable pageable) {
        return projectRepo.findAll(pageable);
    }


    @GetMapping("/project/{ProjectId}")
    public Optional<ProjectModel> getProjectById(@PathVariable Long projectId) {
        return projectRepo.findById(projectId);
    }
    @PostMapping("/project")
    public ProjectModel createProject(@Valid @RequestBody ProjectModel project) {
        return projectRepo.save(project);
    }

    @PostMapping("/project/update/{projectId}")
    public ProjectModel updateProject(@PathVariable Long projectId,
                                @Valid @RequestBody ProjectModel userRequest) {
        return projectRepo.findById(projectId)
                .map(project -> {
                    project.setName(userRequest.getName());
                    project.setUsers(userRequest.getUsers());
                    return projectRepo.save(project);
                }).orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + projectId));
    }


    @PostMapping("/project/delete/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable Long projectId) {
        return projectRepo.findById(projectId)
                .map(project -> {
                    projectRepo.delete(project);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + projectId));
    }

}
