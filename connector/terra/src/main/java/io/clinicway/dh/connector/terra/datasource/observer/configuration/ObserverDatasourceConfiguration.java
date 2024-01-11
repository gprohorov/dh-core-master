package io.clinicway.dh.connector.terra.datasource.observer.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class ObserverDatasourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.observer")
    public DataSourceProperties observerDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.observer.hikari")
    public DataSource observerDataSource() {
        return observerDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
