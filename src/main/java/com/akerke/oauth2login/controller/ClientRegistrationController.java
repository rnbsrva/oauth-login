package com.akerke.oauth2login.controller;

import com.akerke.oauth2login.dto.ClientRegistrationRequest;
import com.akerke.oauth2login.service.ClientRegistrationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientRegistrationController {

    private ClientRegistrationService clientRegistrationService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewClient(@RequestBody ClientRegistrationRequest request) {
        clientRegistrationService.addClientRegistration(request);
    }

    @DeleteMapping("/{registrationId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void removeClient(@PathVariable String registrationId) {
        clientRegistrationService.removeClientRegistration(registrationId);
    }



}
