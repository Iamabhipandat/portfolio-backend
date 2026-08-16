package com.abhinav.portfoliobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SkillResponseDTO {

    private Long id;

    private String name;

    private String category;

    private String icon;

    private Integer displayOrder;
}