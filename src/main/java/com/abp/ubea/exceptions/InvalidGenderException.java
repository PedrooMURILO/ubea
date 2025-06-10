package com.abp.ubea.exceptions;

public class InvalidGenderException extends RuntimeException {

    public InvalidGenderException() {
        super("Invalid gender. Must be 'M' (male) or 'F' (female).");
    }
}
