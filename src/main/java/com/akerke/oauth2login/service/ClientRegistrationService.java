package com.akerke.oauth2login.service;

import com.akerke.oauth2login.dto.ClientRegistrationRequest;

public interface ClientRegistrationService {

    void addClientRegistration(ClientRegistrationRequest request);

    void removeClientRegistration(String registrationId);
}
