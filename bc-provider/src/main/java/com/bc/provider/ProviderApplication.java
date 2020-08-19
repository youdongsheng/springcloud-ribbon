package com.bc.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        System.setProperty("deploy_env","6661");
        SpringApplication.run(ProviderApplication.class, args);
    }
}
