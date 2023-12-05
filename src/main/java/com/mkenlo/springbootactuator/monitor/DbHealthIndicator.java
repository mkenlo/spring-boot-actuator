package com.mkenlo.springbootactuator.monitor;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DbHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {

        if (isDbHealthy()) {
            return Health.up().withDetail("External Db svc", "Healthy").build();
        }
        return Health.down().withDetail("External Db svc", "Is Not Healthy").build();
    }

    private boolean isDbHealthy() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
