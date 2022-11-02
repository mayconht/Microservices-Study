package com.estudos.greeting.controller;

import com.estudos.greeting.configuration.GreetingConfiguration;
import com.estudos.greeting.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingConfiguration greetingConfiguration;


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {

        if (name.isEmpty()) {
            name = this.greetingConfiguration.getDefaultName();
        }

        return new Greeting(
                this.counter.incrementAndGet(),
                String.format(template, this.greetingConfiguration.getGreeting(), name)
        );
    }
}
