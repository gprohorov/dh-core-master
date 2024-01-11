package io.clinicway.dh.api.consumer.entity.redis;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Connector")
public class Connector implements Serializable {
    public String id;
    public String name;
    public String url;
    public String client_id;
    public String client_secret;

    public Connector (String id, String name, String url, String client_id, String client_secret) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.client_id = client_id;
        this.client_secret = client_secret;
    }
}
