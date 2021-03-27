package com.app.servicebank;

import com.app.servicebank.model.Cliente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicebankApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ServicebankApplication.class, args);

        System.out.println("BANCO RODANDO");
    }

    @Override
    public void run(String... args) throws Exception {

        //PARA INSTANCIAR UM OBJ DIRETO NO BANCO

//        Cliente cliente1  = new Cliente();

    }
}
