package com.abhinav.portfoliobackend.repository;

import com.abhinav.portfoliobackend.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}