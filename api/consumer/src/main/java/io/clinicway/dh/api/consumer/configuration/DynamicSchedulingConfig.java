package io.clinicway.dh.api.consumer.configuration;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.clinicway.dh.api.consumer.manager.TokenManager;
import io.clinicway.dh.api.consumer.manager.TokenManagerKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@ComponentScan("io.clinicway.dh.api.consumer.manager")
@EnableScheduling
public class DynamicSchedulingConfig implements SchedulingConfigurer {
    @Autowired
    private TokenManagerKeeper tokenManagerKeeper;

    @Bean
    public Executor taskExecutor() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
        HashMap<String, TokenManager> tokenManagers = tokenManagerKeeper.getTokenManagers();

        tokenManagers.forEach((key, manager) -> {
            taskRegistrar.addTriggerTask(
                    () -> {
                        try {
                            manager.tick();
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    },
                    context -> {
                        Optional<Date> lastCompletionTime =
                                Optional.ofNullable(context.lastCompletionTime());
                        Instant nextExecutionTime =
                                lastCompletionTime.orElseGet(Date::new).toInstant()
                                        .plusMillis(manager.getDelay());
                        return Date.from(nextExecutionTime);
                    }
            );
        });

    }
}
