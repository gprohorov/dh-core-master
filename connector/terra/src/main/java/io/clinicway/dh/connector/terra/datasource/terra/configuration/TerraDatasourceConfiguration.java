package io.clinicway.dh.connector.terra.datasource.terra.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class TerraDatasourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.terra")
    public DataSourceProperties terraDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.terra.hikari")
    public DataSource terraDataSource() {
        return terraDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
