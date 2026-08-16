package com.abhinav.portfoliobackend.dto;

import com.abhinav.portfoliobackend.entity.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ProjectResponseDTO {

    private Long id;

    private String title;

    private String description;

    private String imageUrl;

    private String githubUrl;

    private String liveUrl;

    private ProjectStatus status;

    private boolean featured;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}