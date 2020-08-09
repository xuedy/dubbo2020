package com.example.springcloulddubboserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringClouldDubboServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringClouldDubboServerApplication.class, args);
    }

}
