package com.capgemini.cameltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class UserService {
	
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World! this is sprint boot";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(UserService.class, args);
    }

}
