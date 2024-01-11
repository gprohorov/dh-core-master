package io.clinicway.dh.api.consumer.manager;

import io.clinicway.dh.api.consumer.entity.redis.Connector;
import io.clinicway.dh.api.consumer.repository.ConnectorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope("singleton")
public class AuthenticationManagerRepository {
    Logger logger = LoggerFactory.getLogger(AuthenticationManagerRepository.class);
    public Map<String, AuthenticationManager> authenticationManagers = new HashMap<>();

    public AuthenticationManagerRepository(@Value("${issuer-uri}") String issuerUri, ConnectorRepository connectorRepository) throws URISyntaxException {
//        Connector connector = new Connector("dh", "DH", "http://localhost:6210", "connector-app", "HssgRJQgKkGxunFR2gmvHAd0p0GlMlw6");
//        connectorRepository.save(connector);
        Iterable<Connector> connectors = connectorRepository.findAll();

        for (Connector connector : connectors) {
            String uri = issuerUri + "/realms/" + connector.id;
            logger.info("AuthenticationManagerRepository: " + uri);
            try {
                JwtAuthenticationProvider authenticationProvider = new JwtAuthenticationProvider
                        (JwtDecoders.fromIssuerLocation(uri));
                authenticationManagers.put(uri, authenticationProvider::authenticate);
            } catch (Exception e) {
                logger.error(e.toString());
            }
        }
    }

    public AuthenticationManager get(String issuer) {
        return authenticationManagers.get(issuer);
    }
}
