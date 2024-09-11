package com.application.zuulproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import javax.swing.*;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulproxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulproxyApplication.class, args);
    }
}
