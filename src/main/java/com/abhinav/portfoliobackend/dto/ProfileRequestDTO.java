package com.abhinav.portfoliobackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ProfileRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Headline is required")
    private String headline;

    private String bio;

    @Email(message = "Invalid email format")
    private String email;

    private String location;

    private String githubUrl;

    private String linkedinUrl;

    private String resumeUrl;

    private String profileImageUrl;

    public ProfileRequestDTO() {
    }

    public ProfileRequestDTO(
            String name,
            String headline,
            String bio,
            String email,
            String location,
            String githubUrl,
            String linkedinUrl,
            String resumeUrl,
            String profileImageUrl
    ) {
        this.name = name;
        this.headline = headline;
        this.bio = bio;
        this.email = email;
        this.location = location;
        this.githubUrl = githubUrl;
        this.linkedinUrl = linkedinUrl;
        this.resumeUrl = resumeUrl;
        this.profileImageUrl = profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}