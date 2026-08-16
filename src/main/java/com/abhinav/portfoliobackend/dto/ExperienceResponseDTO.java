package com.abhinav.portfoliobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ExperienceResponseDTO {

    private Long id;

    private String company;

    private String role;

    private String type;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean current;

    private String description;
}