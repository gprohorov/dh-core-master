package io.clinicway.dh.connector.terra.datasource.observer.configuration;

import io.clinicway.dh.connector.terra.datasource.observer.entity.Settings;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
                "io.clinicway.dh.connector.terra.datasource.observer.entity",
                "io.clinicway.dh.connector.terra.datasource.observer.repository",
        },
        entityManagerFactoryRef = "observerEntityManagerFactory",
        transactionManagerRef = "observerTransactionManager"
)
public class ObserverJpaConfiguration {
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean observerEntityManagerFactory(
            @Qualifier("observerDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder
    ) {
        return builder
                .dataSource(dataSource)
                .packages(Settings.class)
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager observerTransactionManager(
            @Qualifier("observerEntityManagerFactory") LocalContainerEntityManagerFactoryBean observerEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(observerEntityManagerFactory.getObject()));
    }
}
