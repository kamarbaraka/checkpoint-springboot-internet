package com.example.checkpointspringbootinternet.app.exception;

public class ResourceNotFoundException extends Throwable{

    public ResourceNotFoundException(){
        super("resource not found");
    }
}
