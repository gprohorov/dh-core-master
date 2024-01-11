package io.clinicway.dh.api.consumer.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;


@Configuration
public class JedisConfig {
    @Value("${redis.client.host}")
    private String redisHost;
    @Value("${redis.client.port}")
    private int redisPort;
    @Value("${redis.client.database}")
    private int redisDatabase;
    @Value("${redis.client.password}")
    private String redisPassword;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();

        jedisConFactory.setHostName(redisHost);
        jedisConFactory.setPort(redisPort);
        jedisConFactory.setDatabase(redisDatabase);

        if (!Objects.equals(redisPassword, "")) {
            jedisConFactory.setPassword(redisPassword);
        }

        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
