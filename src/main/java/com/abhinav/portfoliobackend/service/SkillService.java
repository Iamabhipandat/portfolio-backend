package com.abhinav.portfoliobackend.service;

import com.abhinav.portfoliobackend.dto.SkillRequestDTO;
import com.abhinav.portfoliobackend.dto.SkillResponseDTO;
import com.abhinav.portfoliobackend.entity.Skill;
import com.abhinav.portfoliobackend.repository.SkillRepository;
import org.springframework.stereotype.Service;
import com.abhinav.portfoliobackend.exception.SkillNotFoundException;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }


    // Create
    public SkillResponseDTO createSkill(SkillRequestDTO dto) {

        Skill skill = Skill.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .icon(dto.getIcon())
                .displayOrder(dto.getDisplayOrder())
                .build();

        Skill savedSkill = skillRepository.save(skill);

        return mapToResponse(savedSkill);
    }

    // Get all
    public List<SkillResponseDTO> getAllSkills() {

        return skillRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Get by ID
    public SkillResponseDTO getSkillById(Long id) {

        Skill skill = skillRepository.findById(id)
                .orElseThrow(() ->
                        new SkillNotFoundException("Skill not found with id: " + id)
                );

        return mapToResponse(skill);
    }

    // Convert Entity → Response DTO
    private SkillResponseDTO mapToResponse(Skill skill) {

        return new SkillResponseDTO(
                skill.getId(),
                skill.getName(),
                skill.getCategory(),
                skill.getIcon(),
                skill.getDisplayOrder()
        );
    }
    public SkillResponseDTO updateSkill(
            Long id,
            SkillRequestDTO dto
    ) {

        Skill existingSkill = skillRepository.findById(id)
                .orElseThrow(() ->
                        new SkillNotFoundException("Skill not found with id: " + id)
                );

        existingSkill.setName(dto.getName());
        existingSkill.setCategory(dto.getCategory());
        existingSkill.setIcon(dto.getIcon());
        existingSkill.setDisplayOrder(dto.getDisplayOrder());

        Skill updatedSkill = skillRepository.save(existingSkill);

        return mapToResponse(updatedSkill);
    }
    public void deleteSkill(Long id) {

        Skill skill = skillRepository.findById(id)
                .orElseThrow(() ->
                        new SkillNotFoundException("Skill not found with id: " + id)
                );

        skillRepository.delete(skill);
    }
}