package com.geo.semiproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SemiProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SemiProjectApplication.class, args);
    }

}
