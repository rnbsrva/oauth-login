package com.akerke.oauth2login.dto;

import java.util.Set;

public record ClientRegistrationRequest(
        String registrationId,
        String clientId,
        String clientSecret,
        String clientAuthenticationMethod,
        String authorizationGrantType,
        String jwkSetUri,
        String issuerUri,
        String configurationMetadata,
        String providerName,
        String userInfoAuthenticationMethod,
        String redirectUri,
        String scopes,
        String authorizationUri,
        String tokenUri,
        String userInfoUri,
        String userNameAttributeName,
        String clientName
) {

}
