package io.clinicway.dh.api.consumer.scheduler;

import org.springframework.boot.configurationprocessor.json.JSONException;

public interface DynamicScheduled {
    public long getDelay();

    public void tick() throws JSONException;
}
