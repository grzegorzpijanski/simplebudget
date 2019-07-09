package com.typicaldev.simplebudget;

import com.vaadin.flow.spring.annotation.EnableVaadin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SimplebudgetApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SimplebudgetApplication.class, args);
    }
}