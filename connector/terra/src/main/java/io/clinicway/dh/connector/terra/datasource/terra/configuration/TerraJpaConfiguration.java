package io.clinicway.dh.connector.terra.datasource.terra.configuration;

import io.clinicway.dh.connector.terra.datasource.terra.entity.PersonContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {
                "io.clinicway.dh.connector.terra.datasource.terra.entity",
                "io.clinicway.dh.connector.terra.datasource.terra.repository",
        },
        entityManagerFactoryRef = "terraEntityManagerFactory",
        transactionManagerRef = "terraTransactionManager"
)
public class TerraJpaConfiguration {
    @Bean
    public LocalContainerEntityManagerFactoryBean terraEntityManagerFactory(
            @Qualifier("terraDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages(PersonContainer.class)
                .build();
    }

    @Bean
    public PlatformTransactionManager terraTransactionManager(
            @Qualifier("terraEntityManagerFactory") LocalContainerEntityManagerFactoryBean terraEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(terraEntityManagerFactory.getObject()));
    }
}
