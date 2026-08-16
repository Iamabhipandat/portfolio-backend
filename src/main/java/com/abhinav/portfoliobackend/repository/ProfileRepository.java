package com.abhinav.portfoliobackend.repository;

import com.abhinav.portfoliobackend.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}