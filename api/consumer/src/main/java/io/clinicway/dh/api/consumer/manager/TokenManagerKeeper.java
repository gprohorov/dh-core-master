package io.clinicway.dh.api.consumer.manager;

import io.clinicway.dh.api.consumer.entity.redis.Connector;
import io.clinicway.dh.api.consumer.repository.ConnectorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
@Scope("singleton")
public class TokenManagerKeeper {
    private final HashMap<String, TokenManager> tokenManagers = new HashMap<>();

    public TokenManagerKeeper(@Value("${issuer-uri}") String issuerUri, ConnectorRepository connectorRepository, RestTemplate restTemplate) {
        Iterable<Connector> connectors = connectorRepository.findAll();

        for (Connector connector : connectors) {
            tokenManagers.put(
                    connector.id,
                    new TokenManager(
                            restTemplate,
                            issuerUri,
                            connector.id,
                            connector.client_id,
                            connector.client_secret
                    )
            );
        }
    }

    public TokenManager getTokenManager(String name) {
        return tokenManagers.get(name);
    }

    public HashMap<String, TokenManager> getTokenManagers() {
        return tokenManagers;
    }
}
