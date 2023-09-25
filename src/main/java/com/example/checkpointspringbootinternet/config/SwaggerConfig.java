package com.example.checkpointspringbootinternet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * the swagger ui configuration.
 * @author kamar baraka.*/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){

        /*construct the docket builder*/
        ApiSelectorBuilder builder = new Docket(DocumentationType.SWAGGER_2).select();

        /*set properties*/
        builder.apis(RequestHandlerSelectors.basePackage(
                "com.example.checkpointspringbootinternet.controller"));
        builder.paths(PathSelectors.any());
        /*build and return the docket*/
        return builder.build().apiInfo(this.apiInfo());
    }

    private ApiInfo apiInfo(){

        /*construct an api info*/
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        /*set the properties*/
        apiInfoBuilder.title("To-Do List Api documentation");
        apiInfoBuilder.description("a REST Api to create, update, delete and get To-Do's");
        apiInfoBuilder.version("1.0.0");

        /*build and return the api info*/
        return apiInfoBuilder.build();
    }
}
