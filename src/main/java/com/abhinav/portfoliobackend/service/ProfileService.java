package com.abhinav.portfoliobackend.service;

import com.abhinav.portfoliobackend.dto.ProfileRequestDTO;
import com.abhinav.portfoliobackend.dto.ProfileResponseDTO;
import com.abhinav.portfoliobackend.entity.Profile;
import com.abhinav.portfoliobackend.repository.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // CREATE
    public ProfileResponseDTO createProfile(ProfileRequestDTO dto) {

        Profile profile = Profile.builder()
                .name(dto.getName())
                .headline(dto.getHeadline())
                .bio(dto.getBio())
                .email(dto.getEmail())
                .location(dto.getLocation())
                .githubUrl(dto.getGithubUrl())
                .linkedinUrl(dto.getLinkedinUrl())
                .resumeUrl(dto.getResumeUrl())
                .profileImageUrl(dto.getProfileImageUrl())
                .build();

        Profile savedProfile = profileRepository.save(profile);

        return mapToResponse(savedProfile);
    }

    // GET PROFILE
    public ProfileResponseDTO getProfile() {

        Profile profile = profileRepository.findAll()
                .stream()
                .findFirst()
                .orElse(null);

        if (profile == null) {
            return null;
        }

        return mapToResponse(profile);
    }

    // UPDATE PROFILE
    public ProfileResponseDTO updateProfile(
            ProfileRequestDTO dto
    ) {

        Profile profile = profileRepository.findAll()
                .stream()
                .findFirst()
                .orElseGet(() -> {

                    Profile newProfile = new Profile();

                    return newProfile;
                });

        profile.setName(dto.getName());
        profile.setHeadline(dto.getHeadline());
        profile.setBio(dto.getBio());
        profile.setEmail(dto.getEmail());
        profile.setLocation(dto.getLocation());
        profile.setGithubUrl(dto.getGithubUrl());
        profile.setLinkedinUrl(dto.getLinkedinUrl());
        profile.setResumeUrl(dto.getResumeUrl());
        profile.setProfileImageUrl(dto.getProfileImageUrl());

        Profile savedProfile = profileRepository.save(profile);

        return mapToResponse(savedProfile);
    }

    // ENTITY → DTO
    private ProfileResponseDTO mapToResponse(Profile profile) {

        return new ProfileResponseDTO(
                profile.getId(),
                profile.getName(),
                profile.getHeadline(),
                profile.getBio(),
                profile.getEmail(),
                profile.getLocation(),
                profile.getGithubUrl(),
                profile.getLinkedinUrl(),
                profile.getResumeUrl(),
                profile.getProfileImageUrl()
        );
    }
}