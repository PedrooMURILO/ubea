package com.abp.ubea.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Integer id) {
        super("Resource not found. Id " + id);
    }
}
