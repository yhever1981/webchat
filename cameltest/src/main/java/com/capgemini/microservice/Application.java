package com.capgemini.microservice;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/greeting").allowedOrigins("http://localhost:9000");
            }
        };
    }
    
    @Bean
    public EmbeddedServletContainerFactory servletContainer()
    {
    	TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory ();
    	
    	factory.setPort(9000);
    	factory.setSessionTimeout(10,TimeUnit.MINUTES);
//    	factory.addErrorPages(new ErrorPage());
    	return factory;
    }

}