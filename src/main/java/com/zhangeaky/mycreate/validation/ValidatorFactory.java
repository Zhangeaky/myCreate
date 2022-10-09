package com.zhangeaky.mycreate.validation;

import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.routines.DateValidator;

import java.util.Date;

public abstract class ValidatorFactory {

    public static DateValidator getDateValidator() {
        return DateValidator.getInstance();
    }

    public static void test() {
        //GenericValidator.
    }
    public static void main(String[] args) {
        DateValidator dateValidator = ValidatorFactory.getDateValidator();

        Date validate = dateValidator.validate("");


    }
}

