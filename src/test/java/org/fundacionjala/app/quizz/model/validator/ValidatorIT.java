package org.fundacionjala.app.quizz.model.validator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorIT {

    @Test
    public void testDateValidator() {
        List<String> errors = new ArrayList<>();
        Validator dateValidator = ValidatorType.DATE.getValidator();

        dateValidator.validate("24/12/2021", null, errors);

        Assert.assertEquals(DateValidator.class, dateValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void testDateValidatorError() {
        List<String> errors = new ArrayList<>();
        Validator dateValidator = ValidatorType.DATE.getValidator();

        dateValidator.validate("a24/05/2020", null, errors);

        Assert.assertEquals(DateValidator.class, dateValidator.getClass());

        Assert.assertFalse(errors.isEmpty());
    }

    @Test
    public void testMaxLengthValidator() {
        List<String> errors = new ArrayList<>();
        Validator maxLengthValidator = ValidatorType.MAX_LENGTH.getValidator();

        maxLengthValidator.validate("12345", "5", errors);

        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void testMaxLengthValidatorError() {
        List<String> errors = new ArrayList<>();
        Validator maxLengthValidator = ValidatorType.MAX_LENGTH.getValidator();

        maxLengthValidator.validate("1234567891011", "10", errors);

        Assert.assertFalse(errors.isEmpty());
    }


    @Test
    public void testMinLengthValidator() {
        List<String> errors = new ArrayList<>();
        Validator minLengthValidator = ValidatorType.MIN_LENGTH.getValidator();

        minLengthValidator.validate("12345", "3", errors);

        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void testMinLengthValidatorError() {
        List<String> errors = new ArrayList<>();
        Validator minLengthValidator = ValidatorType.MIN_LENGTH.getValidator();

        minLengthValidator.validate("45", "3", errors);

        Assert.assertFalse(errors.isEmpty());
    }

    @Test
    public void testMinValidator() {
        List<String> errors = new ArrayList<>();
        Validator minValidator = ValidatorType.MIN.getValidator();

        minValidator.validate("101", "100", errors);

        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void testMinValidatorError() {
        List<String> errors = new ArrayList<>();
        Validator minValidator = ValidatorType.MIN.getValidator();

        minValidator.validate("99", "100", errors);

        Assert.assertFalse(errors.isEmpty());
    }


    @Test
    public void testOnlyUpperValidator() {
        List<String> errors = new ArrayList<>();
        Validator validator = ValidatorType.ONLY_UPPER_CASE.getValidator();

        validator.validate("ASDFASDF",null, errors);

        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void testOnlyUpperValidatorError() {
        List<String> errors = new ArrayList<>();
        Validator validator = ValidatorType.ONLY_UPPER_CASE.getValidator();

        validator.validate("ASDFASDFasd",null, errors);

        Assert.assertFalse(errors.isEmpty());
    }

    @Test
    public void testOnlyUpperValidatorErrorWithNumbers() {
        List<String> errors = new ArrayList<>();
        Validator validator = ValidatorType.ONLY_UPPER_CASE.getValidator();

        validator.validate("JFSDJSFK",null, errors);

        Assert.assertFalse(errors.isEmpty());
    }

    @Test
    public void testRequiredValidator() {
        List<String> errors = new ArrayList<>();
        Validator validator = ValidatorType.REQUIRED.getValidator();

        validator.validate("required",null, errors);

        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void testRequiredValidatorError() {
        List<String> errors = new ArrayList<>();
        Validator validator = ValidatorType.REQUIRED.getValidator();

        validator.validate("",null, errors);

        Assert.assertFalse(errors.isEmpty());
    }
}
