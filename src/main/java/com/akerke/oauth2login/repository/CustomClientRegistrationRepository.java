package com.akerke.oauth2login.repository;

import com.akerke.oauth2login.dto.ClientRegistrationRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CustomClientRegistrationRepository implements ClientRegistrationRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomClientRegistrationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(ClientRegistrationRequest clientRegistrationRequest) {
        String sql = "INSERT INTO oauth2_client_registration " +
                "(registration_id," +
                " client_id, " +
                "client_secret, " +
                "client_authentication_method, " +
                "authorization_grant_type, " +
                "client_name, " +
                "redirect_uri, " +
                "scopes," +
                " authorization_uri," +
                " token_uri," +
                " jwk_set_uri, " +
                "issuer_uri," +
                " user_info_uri," +
                " user_info_authentication_method," +
                " user_name_attribute_name, " +
                "configuration_metadata, " +
                "provider_name) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                clientRegistrationRequest.registrationId(),
                clientRegistrationRequest.
                        clientId(),
                clientRegistrationRequest.clientSecret(),
                ClientAuthenticationMethod.CLIENT_SECRET_BASIC,
                AuthorizationGrantType.AUTHORIZATION_CODE,
                clientRegistrationRequest.clientName(),
                clientRegistrationRequest.redirectUri(),
                clientRegistrationRequest.scopes(),
                clientRegistrationRequest.authorizationUri(),
                clientRegistrationRequest.tokenUri(),
                clientRegistrationRequest.jwkSetUri(),
                clientRegistrationRequest.issuerUri(),
                clientRegistrationRequest.userInfoUri(),
                clientRegistrationRequest.userInfoAuthenticationMethod(),
                clientRegistrationRequest.userNameAttributeName(),
                clientRegistrationRequest.configurationMetadata(),
                clientRegistrationRequest.providerName());
    }

    @Override
    public ClientRegistration findByRegistrationId(String registrationId) {
        String sql = "SELECT * FROM oauth2_client_registration WHERE registration_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{registrationId}, new ClientRegistrationRowMapper());
    }
}


class ClientRegistrationRowMapper implements RowMapper<ClientRegistration> {
    @Override
    public ClientRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ClientRegistration.withRegistrationId(rs.getString("registration_id"))
                .registrationId(rs.getString("registration_id"))
                .clientId(rs.getString("client_id"))
                .clientSecret(rs.getString("client_secret"))
//                    .clientAuthenticationMethod(rs.getString("client_authentication_method"))
//                    .authorizationGrantType(rs.getString("authorization_grant_type"))
                .clientName(rs.getString("client_name"))
                .redirectUri(rs.getString("redirect_uri"))
//                    .scopes(rs.getString("scopes"))
                .authorizationUri(rs.getString("authorization_uri"))
                .tokenUri(rs.getString("token_uri"))
                .jwkSetUri(rs.getString("jwk_set_uri"))
                .issuerUri(rs.getString("issuer_uri"))
                .userInfoUri(rs.getString("user_info_uri"))
//                    .userInfoAuthenticationMethod(rs.getString("user_info_authentication_method"))
                .userNameAttributeName(rs.getString("user_name_attribute_name"))
//                    .configurationMetadata(rs.getString("configuration_metadata"))
//                    .providerName(rs.getString("provider_name"))
                .build();
    }

}