package com.javathinking.commons.validation;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO support externalisation of error messages and support i18n
 *
 * @author paul
 */
public class Validator {
    private static final Logger log = Logger.getLogger(Validator.class);

    private List<ValidationRule> rules = new ArrayList();
    private boolean failfast = false;

    public Validator() {
        this.failfast = false;
    }

    public Validator(boolean failfast, ValidationRule... rules) {
        this.failfast = failfast;
        this.rules.addAll(Arrays.asList(rules));
    }

    public Errors validate(Object object) {
        try {
            Errors errors = new Errors();
            for (ValidationRule rule : rules) {
                Errors errs = rule.validate(object);
                errors.add(errs);
                if (!errs.isEmpty()) {
                    log.debug("Validation failed for " + object + " (" + rule.getClass().getSimpleName() + ")");
                } else {
                    log.debug("Validation succeeded for " + object + " (" + rule.getClass().getSimpleName() + ")");
                }
                if (failfast && !errors.isEmpty()) {
                    return errors;
                }
            }
            return errors;
        } catch (ValidationRuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(ValidationRule rule) {
        rules.add(rule);
    }
}
