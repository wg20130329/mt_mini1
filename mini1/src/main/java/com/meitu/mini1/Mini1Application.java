package com.meitu.mini1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Mini1Application {

    public static void main(String[] args) {
        SpringApplication.run(Mini1Application.class, args);
    }

}
