package com.abhinav.portfoliobackend.repository;

import com.abhinav.portfoliobackend.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository
        extends JpaRepository<ContactMessage, Long> {
}