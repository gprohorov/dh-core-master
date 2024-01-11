package io.clinicway.dh.api.consumer.filter;

import io.clinicway.dh.api.consumer.util.DecodedToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(0)
public class CompanyFilter extends OncePerRequestFilter {
    Logger logger = LoggerFactory.getLogger(CompanyFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            String stringToken = authorizationHeader.substring(7);

            DecodedToken token = DecodedToken.getDecoded(stringToken);

            String[] pieces = token.iss.split("\\/");
            request.setAttribute("realm", pieces[pieces.length - 1]);
            request.setAttribute("client_id", token.azp);
            request.setAttribute("preferred_username", token.preferred_username);

            logger.debug("Request realm: " + request.getAttribute("realm"));
            logger.debug("Request client_id: " + request.getAttribute("client_id"));
            logger.debug("Request preferred_username: " + request.getAttribute("preferred_username"));
        }

        chain.doFilter(request, response);
    }
}
