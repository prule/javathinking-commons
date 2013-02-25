/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javathinking.commons.validation;

/**
 * @author paul
 */
public class ValidationRuntimeException extends RuntimeException {

    public ValidationRuntimeException(Throwable cause) {
        super(cause);
    }

    public ValidationRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationRuntimeException(String message) {
        super(message);
    }

    public ValidationRuntimeException() {
    }

}
