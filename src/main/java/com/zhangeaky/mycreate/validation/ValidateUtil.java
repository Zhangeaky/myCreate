package com.zhangeaky.mycreate.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidateUtil {

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> List<String> validate(T obj) {

        Set<ConstraintViolation<T>> validate = VALIDATOR.validate(obj);
        return validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }

}
