package com.techo.sports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by TXT0627 on 6/17/2016.
 */
@SpringBootApplication
@ComponentScan
@EnableScheduling
public class Application {
    public static void main(final String args[]) {
        SpringApplication.run(Application.class, args);
    }
}
