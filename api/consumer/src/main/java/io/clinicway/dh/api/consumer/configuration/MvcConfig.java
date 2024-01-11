package io.clinicway.dh.api.consumer.configuration;

import io.clinicway.dh.api.consumer.interceptor.ConnectorExistInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("io.clinicway.dh.api.consumer.interceptor")
public class MvcConfig extends WebMvcConfigurerAdapter {
    private ConnectorExistInterceptor connectorExistInterceptor;

    @SuppressWarnings("unused")
    public MvcConfig() {
    }

    @Autowired
    public MvcConfig(ConnectorExistInterceptor connectorExistInterceptor) {
        this.connectorExistInterceptor = connectorExistInterceptor;
    }

    @Autowired
    public void setClientExistInterceptor(ConnectorExistInterceptor connectorExistInterceptor) {
        this.connectorExistInterceptor = connectorExistInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(connectorExistInterceptor);
        super.addInterceptors(registry);
    }
}
