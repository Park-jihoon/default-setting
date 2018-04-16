package com.pohinian.springvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class SpringVueApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!!!";
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringVueApplication.class, args);
    }
}
