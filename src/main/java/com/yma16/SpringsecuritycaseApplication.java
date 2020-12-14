package com.yma16;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yma16.mapper")
public class SpringsecuritycaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecuritycaseApplication.class, args);
    }

}
