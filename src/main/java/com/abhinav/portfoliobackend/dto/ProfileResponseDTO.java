package com.abhinav.portfoliobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfileResponseDTO {

    private Long id;

    private String name;

    private String headline;

    private String bio;

    private String email;

    private String location;

    private String githubUrl;

    private String linkedinUrl;

    private String resumeUrl;

    private String profileImageUrl;
}