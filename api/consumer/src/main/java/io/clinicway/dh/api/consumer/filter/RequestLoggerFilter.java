package io.clinicway.dh.api.consumer.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class RequestLoggerFilter extends OncePerRequestFilter {
    Logger logger = LoggerFactory.getLogger(RequestLoggerFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        logger.info("Request url: " + request.getRequestURI() + ", Params: " + request.getQueryString() + ", Realm: " + request.getAttribute("realm"));

        chain.doFilter(request, response);
    }
}
