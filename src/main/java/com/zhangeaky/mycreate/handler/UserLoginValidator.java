package com.zhangeaky.mycreate.handler;

import com.zhangeaky.mycreate.annotations.NotExist;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class UserLoginValidator implements ConstraintValidator<NotExist, String> {

    private final static HashMap<String, String> userTable = new LinkedHashMap<>(16);

    @PostConstruct
    void initTable() {
        userTable.put("yida", "张已开");
        userTable.put("tongshao", "呵呵呵");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid = Objects.nonNull(userTable.get(value));

        // 如果不屏蔽默认实现的话，就会产生重复， 默认的和后来添加的都会进去。
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("user not exist!! please check").addConstraintViolation();

        return isValid;
    }
}
