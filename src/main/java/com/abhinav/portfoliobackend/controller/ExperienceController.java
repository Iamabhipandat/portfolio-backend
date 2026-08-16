package com.abhinav.portfoliobackend.controller;

import com.abhinav.portfoliobackend.dto.ExperienceRequestDTO;
import com.abhinav.portfoliobackend.dto.ExperienceResponseDTO;
import com.abhinav.portfoliobackend.service.ExperienceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(
            ExperienceService experienceService
    ) {
        this.experienceService = experienceService;
    }

    // CREATE
    @PostMapping
    public ExperienceResponseDTO createExperience(
            @Valid @RequestBody ExperienceRequestDTO experience
    ) {
        return experienceService.createExperience(experience);
    }

    // GET ALL
    @GetMapping
    public List<ExperienceResponseDTO> getAllExperiences() {
        return experienceService.getAllExperiences();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ExperienceResponseDTO getExperienceById(
            @PathVariable Long id
    ) {
        return experienceService.getExperienceById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ExperienceResponseDTO updateExperience(
            @PathVariable Long id,
            @Valid @RequestBody ExperienceRequestDTO experience
    ) {
        return experienceService.updateExperience(
                id,
                experience
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
    }
}