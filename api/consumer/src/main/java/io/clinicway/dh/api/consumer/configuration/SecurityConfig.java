package io.clinicway.dh.api.consumer.configuration;

import io.clinicway.dh.api.consumer.manager.AuthenticationManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecurityConfig {
    @Autowired
    private AuthenticationManagerRepository authenticationManagerRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        JwtIssuerAuthenticationManagerResolver authenticationManagerResolver =
                new JwtIssuerAuthenticationManagerResolver(authenticationManagerRepository::get);

        http.authorizeRequests(authz -> authz.antMatchers(HttpMethod.GET, "/orders/**")
                        .hasAuthority("SCOPE_profile")
                        .antMatchers(HttpMethod.GET, "/orders")
                        .hasAuthority("SCOPE_profile")
                        .antMatchers(HttpMethod.GET, "/patient")
                        .hasAuthority("SCOPE_profile")
                        .anyRequest()
                        .authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.authenticationManagerResolver(authenticationManagerResolver));
        return http.build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
