package com.javathinking.commons.validation;

/**
 * @author paul
 */
public interface ValidationRule<T> {
    /**
     * @param input
     * @return Errors, or null if input passes validation
     */
    Errors validate(T input);

}
