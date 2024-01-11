package io.clinicway.dh.api.consumer.manager;

import io.clinicway.dh.api.consumer.scheduler.DynamicScheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class TokenManager implements DynamicScheduled {
    Logger logger = LoggerFactory.getLogger(TokenManager.class);
    private long delay = 1000L;

    private final String issuerUri;

    private final String realm;

    private final String clientId;

    private final String clientSecret;

    private String tokenType = "";

    private String accessToken = "";

    private final RestTemplate restTemplate;

    public TokenManager(RestTemplate restTemplate, String issuerUri, String realm, String clientId, String clientSecret) {
        this.restTemplate = restTemplate;
        this.issuerUri = issuerUri;
        this.realm = realm;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public long getDelay() {
        return delay;
    }

    public String getAuthToken() {
        return tokenType + " " + accessToken;
    }

    public void tick() throws JSONException {
        String url = issuerUri + "/realms/" + realm + "/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> credentials = new LinkedMultiValueMap<String, String>();
        credentials.add("client_id", clientId);
        credentials.add("client_secret", clientSecret);
        credentials.add("grant_type", "client_credentials");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(credentials, headers);

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
            JSONObject token = new JSONObject(response.getBody());

            accessToken = token.getString("access_token");
            tokenType = token.getString("token_type");
            delay = (token.getInt("expires_in") - 10) * 1000L;
        } catch (Exception e) {
            logger.error(e.toString());
            delay = 300000L;
        }
    }
}
