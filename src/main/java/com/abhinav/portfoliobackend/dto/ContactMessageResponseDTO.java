package com.abhinav.portfoliobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ContactMessageResponseDTO {

    private Long id;

    private String name;

    private String email;

    private String subject;

    private String message;

    private LocalDateTime createdAt;
}