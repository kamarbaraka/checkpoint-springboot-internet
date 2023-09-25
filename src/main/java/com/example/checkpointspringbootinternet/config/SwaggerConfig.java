package com.example.checkpointspringbootinternet.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * the swagger ui configuration.
 * @author kamar baraka.*/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket docket(){
        return null;
    }
}
