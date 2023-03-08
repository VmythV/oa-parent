package com.myth.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author may
 */
@SpringBootApplication
@ComponentScan({"com.myth"})
public class ServiceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }

}