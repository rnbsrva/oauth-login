package com.akerke.oauth2login.service;

import com.akerke.oauth2login.dto.ClientRegistrationRequest;
import com.akerke.oauth2login.repository.CustomClientRegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientRegistrationServiceImpl implements ClientRegistrationService {

    private final CustomClientRegistrationRepository customClientRegistrationRepository;

    public ClientRegistrationServiceImpl(CustomClientRegistrationRepository customClientRegistrationRepository) {
        this.customClientRegistrationRepository = customClientRegistrationRepository;
    }

    @Override
    public void addClientRegistration(ClientRegistrationRequest request) {
        customClientRegistrationRepository.save(request);
    }

    @Override
    public void removeClientRegistration(String registrationId) {
//        customClientRegistrationRepository.removeClientRegistration(registrationId);
    }

}
