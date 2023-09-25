package com.example.checkpointspringbootinternet;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CheckpointSpringbootInternetApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckpointSpringbootInternetApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){

        /*construct and return modelmapper*/
        return new ModelMapper();
    }

}
