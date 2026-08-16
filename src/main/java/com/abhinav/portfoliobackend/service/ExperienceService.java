package com.abhinav.portfoliobackend.service;

import com.abhinav.portfoliobackend.dto.ExperienceRequestDTO;
import com.abhinav.portfoliobackend.dto.ExperienceResponseDTO;
import com.abhinav.portfoliobackend.entity.Experience;
import com.abhinav.portfoliobackend.exception.ExperienceNotFoundException;
import com.abhinav.portfoliobackend.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    // CREATE
    public ExperienceResponseDTO createExperience(
            ExperienceRequestDTO dto
    ) {

        Experience experience = Experience.builder()
                .company(dto.getCompany())
                .role(dto.getRole())
                .type(dto.getType())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .current(dto.isCurrent())
                .description(dto.getDescription())
                .build();

        Experience savedExperience =
                experienceRepository.save(experience);

        return mapToResponse(savedExperience);
    }

    // GET ALL
    public List<ExperienceResponseDTO> getAllExperiences() {

        return experienceRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // GET BY ID
    public ExperienceResponseDTO getExperienceById(Long id) {

        Experience experience = getExperienceEntityById(id);

        return mapToResponse(experience);
    }

    // UPDATE
    public ExperienceResponseDTO updateExperience(
            Long id,
            ExperienceRequestDTO dto
    ) {

        Experience existingExperience =
                getExperienceEntityById(id);

        existingExperience.setCompany(dto.getCompany());
        existingExperience.setRole(dto.getRole());
        existingExperience.setType(dto.getType());
        existingExperience.setStartDate(dto.getStartDate());
        existingExperience.setEndDate(dto.getEndDate());
        existingExperience.setCurrent(dto.isCurrent());
        existingExperience.setDescription(dto.getDescription());

        Experience updatedExperience =
                experienceRepository.save(existingExperience);

        return mapToResponse(updatedExperience);
    }

    // DELETE
    public void deleteExperience(Long id) {

        Experience experience =
                getExperienceEntityById(id);

        experienceRepository.delete(experience);
    }

    // FIND ENTITY
    private Experience getExperienceEntityById(Long id) {

        return experienceRepository.findById(id)
                .orElseThrow(() ->
                        new ExperienceNotFoundException(
                                "Experience not found with id: " + id
                        )
                );
    }

    // ENTITY → DTO
    private ExperienceResponseDTO mapToResponse(
            Experience experience
    ) {

        return new ExperienceResponseDTO(
                experience.getId(),
                experience.getCompany(),
                experience.getRole(),
                experience.getType(),
                experience.getStartDate(),
                experience.getEndDate(),
                experience.isCurrent(),
                experience.getDescription()
        );
    }
}