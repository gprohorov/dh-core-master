package io.clinicway.dh.api.consumer.proxy;

import io.clinicway.dh.api.consumer.entity.redis.Connector;
import io.clinicway.dh.api.consumer.exception.ClientNotFoundException;
import io.clinicway.dh.api.consumer.feature.person.service.PersonServiceImpl;
import io.clinicway.dh.api.consumer.manager.TokenManagerKeeper;
import io.clinicway.dh.api.consumer.repository.ConnectorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ResourceServerProxy {
    Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    public static final String AUTHORIZATION = "Authorization";

    private final HttpServletRequest request;

    private final ConnectorRepository connectorRepository;

    private final TokenManagerKeeper tokenManagerKeeper;

    private final RestTemplate restTemplate;

    public ResourceServerProxy(
            RestTemplate restTemplate,
            TokenManagerKeeper tokenManagerKeeper,
            HttpServletRequest request,
            ConnectorRepository connectorRepository
    ) {
        this.restTemplate = restTemplate;
        this.tokenManagerKeeper = tokenManagerKeeper;
        this.request = request;
        this.connectorRepository = connectorRepository;
    }

    public <T> ResponseEntity<T> getRequest(String resource, HttpMethod method, Class<T> responseType, Map<String, String> params) throws ClientNotFoundException {
        String queryParams = params.keySet().stream().map(key -> key + "=" + params.get(key)).collect(Collectors.joining("&"));
        String path = resource + "?" + queryParams;

        return performRequest(path, method, responseType);
    }

    public <T> ResponseEntity<T> getRequest(String resource, HttpMethod method, Class<T> responseType) throws ClientNotFoundException {
        return performRequest(resource, method, responseType);
    }

    private <T> ResponseEntity<T> performRequest(String path, HttpMethod method, Class<T> responseType) throws ClientNotFoundException {
        Optional<Connector> client = connectorRepository.findById(request.getAttribute("realm").toString());

        if (client.isPresent()) {
            String url = client.get().url + path;

            HttpHeaders headers = new HttpHeaders();
            final String authorizationHeader = tokenManagerKeeper.getTokenManager(client.get().id).getAuthToken();
            headers.add(AUTHORIZATION, authorizationHeader);

            HttpEntity<Void> request = new HttpEntity<>(headers);

            return restTemplate.exchange(url, method, request, responseType);
        } else {
            throw new ClientNotFoundException();
        }
    }
}
