package com.javathinking.commons.validation;

/**
 * @author paul
 */
public class ValidationError {
    private String name;
    private String message;

    public ValidationError(String name, String message) {
        this.name = name;
        this.message = message;
    }

    @Override
    public String toString() {
        return new StringBuffer("Error: ").append(name).append(" - ").append(message).toString();
    }


}
