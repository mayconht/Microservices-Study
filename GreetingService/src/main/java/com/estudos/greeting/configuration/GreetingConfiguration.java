package com.estudos.greeting.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("greeting-service")
public class GreetingConfiguration {
    private String greeting;
    private String defaultName;

    public GreetingConfiguration() {
    }

    public String getGreeting() {
        return this.greeting;
    }

    public void setGreeting(final String greeting) {
        this.greeting = greeting;
    }

    public String getDefaultName() {
        return this.defaultName;
    }

    public void setDefaultName(final String defaultName) {
        this.defaultName = defaultName;
    }
}
