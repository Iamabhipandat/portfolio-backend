package com.abhinav.portfoliobackend.controller;

import com.abhinav.portfoliobackend.dto.ProjectResponseDTO;
import com.abhinav.portfoliobackend.entity.Project;
import com.abhinav.portfoliobackend.service.ProjectService;
import org.springframework.web.bind.annotation.*;
import com.abhinav.portfoliobackend.dto.ProjectRequestDTO;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping
    public ProjectResponseDTO createProject(
            @Valid @RequestBody ProjectRequestDTO project
    ) {
        return projectService.createProject(project);
    }

    @GetMapping
    public List<ProjectResponseDTO> getAllProjects() {
        return projectService.getAllProjects();
    }
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public ProjectResponseDTO updateProject(
            @PathVariable Long id,
            @Valid @RequestBody ProjectRequestDTO project
    ) {
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}