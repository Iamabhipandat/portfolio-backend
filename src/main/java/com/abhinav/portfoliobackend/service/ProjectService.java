package com.abhinav.portfoliobackend.service;

import com.abhinav.portfoliobackend.dto.ProjectRequestDTO;
import com.abhinav.portfoliobackend.dto.ProjectResponseDTO;
import com.abhinav.portfoliobackend.entity.Project;
import com.abhinav.portfoliobackend.repository.ProjectRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private Project getProjectEntityById(Long id) {

        return projectRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Project not found with id: " + id
                        )
                );
    }

    private ProjectResponseDTO mapToResponse(Project project) {

        return new ProjectResponseDTO(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getImageUrl(),
                project.getGithubUrl(),
                project.getLiveUrl(),
                project.getStatus(),
                project.isFeatured(),
                project.getCreatedAt(),
                project.getUpdatedAt()
        );
    }

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Create
    public ProjectResponseDTO createProject(ProjectRequestDTO dto) {

        Project project = Project.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .imageUrl(dto.getImageUrl())
                .githubUrl(dto.getGithubUrl())
                .liveUrl(dto.getLiveUrl())
                .status(dto.getStatus())
                .featured(dto.isFeatured())
                .build();

        Project savedProject = projectRepository.save(project);

        return mapToResponse(savedProject);
    }

    // Get all
    public List<ProjectResponseDTO> getAllProjects() {

        return projectRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Get by ID
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    // Update
    public ProjectResponseDTO updateProject(
            Long id,
            ProjectRequestDTO dto
    ) {

        Project existingProject = getProjectEntityById(id);

        existingProject.setTitle(dto.getTitle());
        existingProject.setDescription(dto.getDescription());
        existingProject.setImageUrl(dto.getImageUrl());
        existingProject.setGithubUrl(dto.getGithubUrl());
        existingProject.setLiveUrl(dto.getLiveUrl());
        existingProject.setStatus(dto.getStatus());
        existingProject.setFeatured(dto.isFeatured());

        Project updatedProject = projectRepository.save(existingProject);

        return mapToResponse(updatedProject);
    }
    // Delete
    public void deleteProject(Long id) {
        Project project = getProjectById(id);
        projectRepository.delete(project);
    }
}