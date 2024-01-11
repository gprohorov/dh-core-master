package io.clinicway.dh.api.consumer.interceptor;

import io.clinicway.dh.api.consumer.entity.redis.Connector;
import io.clinicway.dh.api.consumer.repository.ConnectorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class ConnectorExistInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(ConnectorExistInterceptor.class);

    private final ConnectorRepository connectorRepository;

    public ConnectorExistInterceptor(ConnectorRepository connectorRepository) {
        this.connectorRepository = connectorRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Optional<Connector> client = connectorRepository.findById(request.getAttribute("realm").toString());

        if (client.isPresent()) {
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
            return false;
        }
    }
}
