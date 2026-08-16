package com.abhinav.portfoliobackend.service;

import com.abhinav.portfoliobackend.dto.EducationRequestDTO;
import com.abhinav.portfoliobackend.dto.EducationResponseDTO;
import com.abhinav.portfoliobackend.entity.Education;
import com.abhinav.portfoliobackend.exception.EducationNotFoundException;
import com.abhinav.portfoliobackend.repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    // CREATE
    public EducationResponseDTO createEducation(EducationRequestDTO dto) {

        Education education = Education.builder()
                .degree(dto.getDegree())
                .institution(dto.getInstitution())
                .fieldOfStudy(dto.getFieldOfStudy())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .grade(dto.getGrade())
                .description(dto.getDescription())
                .build();

        Education savedEducation = educationRepository.save(education);

        return mapToResponse(savedEducation);
    }

    // GET ALL
    public List<EducationResponseDTO> getAllEducation() {

        return educationRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // GET BY ID
    public EducationResponseDTO getEducationById(Long id) {

        Education education = getEducationEntityById(id);

        return mapToResponse(education);
    }

    // UPDATE
    public EducationResponseDTO updateEducation(
            Long id,
            EducationRequestDTO dto
    ) {

        Education existingEducation = getEducationEntityById(id);

        existingEducation.setDegree(dto.getDegree());
        existingEducation.setInstitution(dto.getInstitution());
        existingEducation.setFieldOfStudy(dto.getFieldOfStudy());
        existingEducation.setStartDate(dto.getStartDate());
        existingEducation.setEndDate(dto.getEndDate());
        existingEducation.setGrade(dto.getGrade());
        existingEducation.setDescription(dto.getDescription());

        Education updatedEducation =
                educationRepository.save(existingEducation);

        return mapToResponse(updatedEducation);
    }

    // DELETE
    public void deleteEducation(Long id) {

        Education education = getEducationEntityById(id);

        educationRepository.delete(education);
    }

    // FIND ENTITY
    private Education getEducationEntityById(Long id) {

        return educationRepository.findById(id)
                .orElseThrow(() ->
                        new EducationNotFoundException(
                                "Education not found with id: " + id
                        )
                );
    }

    // ENTITY → DTO
    private EducationResponseDTO mapToResponse(Education education) {

        return new EducationResponseDTO(
                education.getId(),
                education.getDegree(),
                education.getInstitution(),
                education.getFieldOfStudy(),
                education.getStartDate(),
                education.getEndDate(),
                education.getGrade(),
                education.getDescription()
        );
    }
}