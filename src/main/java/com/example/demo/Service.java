package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.actuate.metrics.export.prometheus.PrometheusPushGatewayManager;
import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class Service implements CommandLineRunner {

    private final PrometheusPushGatewayManager prometheusPushGatewayManager;

    public Service(PrometheusPushGatewayManager prometheusPushGatewayManager) {
        this.prometheusPushGatewayManager = prometheusPushGatewayManager;
    }

    @PreDestroy
    public void onExit() {
        System.out.println("Exiting..");
        prometheusPushGatewayManager.shutdown();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running");
    }
}
