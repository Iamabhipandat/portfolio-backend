package com.abhinav.portfoliobackend.controller;

import com.abhinav.portfoliobackend.dto.ContactMessageRequestDTO;
import com.abhinav.portfoliobackend.dto.ContactMessageResponseDTO;
import com.abhinav.portfoliobackend.service.ContactMessageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    public ContactMessageController(
            ContactMessageService contactMessageService
    ) {
        this.contactMessageService = contactMessageService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactMessageResponseDTO createMessage(
            @Valid @RequestBody ContactMessageRequestDTO message
    ) {
        return contactMessageService.createMessage(message);
    }
}