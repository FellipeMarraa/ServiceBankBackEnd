package com.app.servicebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicebankApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicebankApplication.class, args);

        System.out.println("BANCO RODANDO");
    }

}
