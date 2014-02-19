package com.javathinking.commons.validation;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * @author paul
 */
public class ValidatorTest {

    Errors errorsSuccess;
    Errors errorsFail;
    ValidationRule rule1, rule2, rule3;

    @Before
    public void setup() {
        errorsSuccess = new Errors();
        errorsFail = new Errors();
        errorsFail.add(new ValidationError(this.getClass().getSimpleName(), "error"));

        rule1 = createMock(ValidationRule.class);
        rule2 = createMock(ValidationRule.class);
        rule3 = createMock(ValidationRule.class);

    }

    @Test
    public void whenNotFailingFastAllRulesShouldExecute() {
        // setup
        expect(rule1.validate(anyObject())).andReturn(errorsSuccess).atLeastOnce();
        expect(rule2.validate(anyObject())).andReturn(errorsFail).atLeastOnce();
        expect(rule3.validate(anyObject())).andReturn(errorsFail).atLeastOnce();
        replay(rule1, rule2, rule3);

        // perform
        Errors errors = doValidation(false, rule1, rule2, rule3);

        // assert
        assertFalse(errors.isEmpty());
        assertThat(errors.getAll(), hasSize(2));
        verify(rule1, rule2, rule3);
    }

    @Test
    public void whenFailingFastValidationShouldStopAfterFirstFailure() {
        // setup
        expect(rule1.validate(anyObject())).andReturn(errorsSuccess).once();
        expect(rule2.validate(anyObject())).andReturn(errorsFail).once();
        replay(rule1, rule2, rule3);

        // perform
        Errors errors = doValidation(true, rule1, rule2, rule3);

        // assert
        assertThat(errors.getAll(), hasSize(1));
        verify(rule1, rule2, rule3);
    }

    @Test
    public void whenThereAreNoErrorsAllRulesShouldExecute() {
        // setup
        expect(rule1.validate(anyObject())).andReturn(errorsSuccess).once();
        expect(rule2.validate(anyObject())).andReturn(errorsSuccess).once();
        expect(rule3.validate(anyObject())).andReturn(errorsSuccess).once();
        replay(rule1, rule2, rule3);

        // perform
        Errors errors = doValidation(true, rule1, rule2, rule3);

        // assert
        assertThat(errors.getAll(), is(empty()));
        verify(rule1, rule2, rule3);
    }

    /**
     * Build a validator with the given configuration
     */
    private Errors doValidation(boolean failfast, ValidationRule... rules) {
        Validator validator = new Validator(failfast);
        for (ValidationRule rule : rules) {
            validator.add(rule);
        }

        return validator.validate(new Object());
    }
}
