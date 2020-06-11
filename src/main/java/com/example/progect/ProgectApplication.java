package com.example.progect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.example.progect.mapper.**")
@SpringBootApplication
public class ProgectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgectApplication.class, args);
    }

}
