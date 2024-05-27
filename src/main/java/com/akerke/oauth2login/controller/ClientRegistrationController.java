package com.akerke.oauth2login.controller;

import com.akerke.oauth2login.dto.ClientRegistrationRequest;
import com.akerke.oauth2login.service.ClientRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientRegistrationController {

    private final ClientRegistrationService clientRegistrationService;

    public ClientRegistrationController(ClientRegistrationService clientRegistrationService) {
        this.clientRegistrationService = clientRegistrationService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewClient(@Validated @RequestBody ClientRegistrationRequest request) {
        clientRegistrationService.addClientRegistration(request);
    }

    @DeleteMapping("/{registrationId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void removeClient(@PathVariable String registrationId) {
        clientRegistrationService.removeClientRegistration(registrationId);
    }

}
