package com.abhinav.portfoliobackend.service;

import com.abhinav.portfoliobackend.dto.ContactMessageRequestDTO;
import com.abhinav.portfoliobackend.dto.ContactMessageResponseDTO;
import com.abhinav.portfoliobackend.entity.ContactMessage;
import com.abhinav.portfoliobackend.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    public ContactMessageService(
            ContactMessageRepository contactMessageRepository
    ) {
        this.contactMessageRepository = contactMessageRepository;
    }

    public ContactMessageResponseDTO createMessage(
            ContactMessageRequestDTO dto
    ) {

        ContactMessage message = ContactMessage.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .subject(dto.getSubject())
                .message(dto.getMessage())
                .createdAt(LocalDateTime.now())
                .build();

        ContactMessage savedMessage =
                contactMessageRepository.save(message);

        return mapToResponse(savedMessage);
    }

    private ContactMessageResponseDTO mapToResponse(
            ContactMessage message
    ) {

        return new ContactMessageResponseDTO(
                message.getId(),
                message.getName(),
                message.getEmail(),
                message.getSubject(),
                message.getMessage(),
                message.getCreatedAt()
        );
    }
}