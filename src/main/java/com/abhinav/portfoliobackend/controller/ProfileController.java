package com.abhinav.portfoliobackend.controller;

import com.abhinav.portfoliobackend.dto.ProfileRequestDTO;
import com.abhinav.portfoliobackend.dto.ProfileResponseDTO;
import com.abhinav.portfoliobackend.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // CREATE
    @PostMapping
    public ProfileResponseDTO createProfile(
            @Valid @RequestBody ProfileRequestDTO profile
    ) {
        return profileService.createProfile(profile);
    }

    // GET
    @GetMapping
    public ProfileResponseDTO getProfile() {
        return profileService.getProfile();
    }

    // UPDATE
    @PutMapping
    public ProfileResponseDTO updateProfile(
            @Valid @RequestBody ProfileRequestDTO profile
    ) {
        return profileService.updateProfile(profile);
    }
}