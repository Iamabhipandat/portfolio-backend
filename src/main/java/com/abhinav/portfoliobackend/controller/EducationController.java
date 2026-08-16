package com.abhinav.portfoliobackend.controller;

import com.abhinav.portfoliobackend.dto.EducationRequestDTO;
import com.abhinav.portfoliobackend.dto.EducationResponseDTO;
import com.abhinav.portfoliobackend.service.EducationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    // CREATE
    @PostMapping
    public EducationResponseDTO createEducation(
            @Valid @RequestBody EducationRequestDTO education
    ) {
        return educationService.createEducation(education);
    }

    // GET ALL
    @GetMapping
    public List<EducationResponseDTO> getAllEducation() {
        return educationService.getAllEducation();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public EducationResponseDTO getEducationById(
            @PathVariable Long id
    ) {
        return educationService.getEducationById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public EducationResponseDTO updateEducation(
            @PathVariable Long id,
            @Valid @RequestBody EducationRequestDTO education
    ) {
        return educationService.updateEducation(id, education);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
    }
}