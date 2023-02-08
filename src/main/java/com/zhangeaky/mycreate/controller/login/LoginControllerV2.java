package com.zhangeaky.mycreate.controller.login;

import com.zhangeaky.mycreate.validation.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
public class LoginControllerV2 {

    @Autowired
    JdbcTemplate jdbcTemplate;


    /**
     * bean validate的第一种校验方式
     * 在java bean 的字段上使用 javax 约束注解
     * 使用校验器spi 进行校验。
     * @param request
     * @return
     */
    @RequestMapping("yida/login/test")
    Integer test(@RequestBody LoginRequest request) {

        return ValidateUtil.validate(request).size();

    }

    @GetMapping("yida/api/login/testv1")
    @Validated
    String testV1(@RequestBody @Valid LoginRequest request, BindingResult bindingResult) {
        System.out.println(bindingResult);
        bindingResult.hasErrors();
        bindingResult.getErrorCount();
        bindingResult.getAllErrors();

        System.out.println("dto: " + request);

        return bindingResult.toString();
    }
}
