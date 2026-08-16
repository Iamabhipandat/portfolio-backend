package com.abhinav.portfoliobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class EducationResponseDTO {

    private Long id;

    private String degree;

    private String institution;

    private String fieldOfStudy;

    private LocalDate startDate;

    private LocalDate endDate;

    private String grade;

    private String description;
}