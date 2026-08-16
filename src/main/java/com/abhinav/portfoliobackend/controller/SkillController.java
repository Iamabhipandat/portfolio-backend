package com.abhinav.portfoliobackend.controller;

import com.abhinav.portfoliobackend.dto.SkillRequestDTO;
import com.abhinav.portfoliobackend.dto.SkillResponseDTO;
import com.abhinav.portfoliobackend.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    // CREATE
    @PostMapping
    public SkillResponseDTO createSkill(
            @Valid @RequestBody SkillRequestDTO skill
    ) {
        return skillService.createSkill(skill);
    }

    // GET ALL
    @GetMapping
    public List<SkillResponseDTO> getAllSkills() {
        return skillService.getAllSkills();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public SkillResponseDTO getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }
    @PutMapping("/{id}")
    public SkillResponseDTO updateSkill(
            @PathVariable Long id,
            @Valid @RequestBody SkillRequestDTO skill
    ) {
        return skillService.updateSkill(id, skill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }
}