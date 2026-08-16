package com.abhinav.portfoliobackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String headline;

    @Column(length = 2000)
    private String bio;

    private String email;

    private String location;

    private String githubUrl;

    private String linkedinUrl;

    private String resumeUrl;

    private String profileImageUrl;
}