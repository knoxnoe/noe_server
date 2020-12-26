package com.noe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
@SpringBootApplication
@MapperScan
public class MainServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainServerApplication.class, args);
    }
}
