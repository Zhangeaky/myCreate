package com.zhangeaky.mycreate.controller.login;

import com.zhangeaky.mycreate.annotations.NotExist;
import com.zhangeaky.mycreate.bean.Env;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginRequest {

    @NotBlank( message = "用户名不能为空")
    @NotExist( message = "用户不存在")
    private String userName;

    @NotBlank( message = "密码不能为空")
    private String passwd;

    @Valid
    private Env env;

    @Size( max = 6, min = 6, message = "验证码位数不正确")
    private String validateCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Env getEnv() {
        return env;
    }

    public void setEnv(Env env) {
        this.env = env;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "userName='" + userName + '\'' +
                ", passwd='" + passwd + '\'' +
                ", env=" + env +
                ", validateCode='" + validateCode + '\'' +
                '}';
    }
}
