package com.example.checkpointspringbootinternet.app.exception;

public class ResourceNotFound extends Throwable{

    public ResourceNotFound(){
        super("resource not found");
    }
}
