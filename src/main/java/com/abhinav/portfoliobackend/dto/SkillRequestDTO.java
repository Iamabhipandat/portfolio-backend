package com.abhinav.portfoliobackend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SkillRequestDTO {

    @NotBlank(message = "Skill name is required")
    private String name;

    @NotBlank(message = "Skill category is required")
    private String category;

    private String icon;

    @NotNull(message = "Display order is required")
    @Min(value = 1, message = "Display order must be at least 1")
    private Integer displayOrder;

    public SkillRequestDTO() {
    }

    public SkillRequestDTO(
            String name,
            String category,
            String icon,
            Integer displayOrder
    ) {
        this.name = name;
        this.category = category;
        this.icon = icon;
        this.displayOrder = displayOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}