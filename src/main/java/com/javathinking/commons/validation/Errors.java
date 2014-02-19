package com.javathinking.commons.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author paul
 */
public class Errors {
    private List<ValidationError> errors = new ArrayList();

    public void add(Errors errs) {
        errors.addAll(errs.getAll());
    }

    public void add(ValidationError err) {
        errors.add(err);
    }

    public List<ValidationError> getAll() {
        return errors;
    }

    public boolean isEmpty() {
        return errors.isEmpty();
    }

    public boolean isValid() {
        return isEmpty();
    }

    public boolean isNotValid() {
        return !isEmpty();
    }

    @Override
    public String toString() {
        return errors.toString();
    }


}
