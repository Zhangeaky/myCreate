package com.zhangeaky.mycreate.validation;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.util.ValidatorUtils;

public class NameValidator {

    public static void validateRequired(Object object, Field field) {
        System.out.println("======" + field + "======");
    }

    public static boolean validateRequireds(Object bean, Field field) {
        String value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        return GenericValidator.isBlankOrNull(value);
    }
}
