package com.zhangeaky.mycreate.validation;

import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorResources;
import org.apache.commons.validator.ValidatorResult;
import org.apache.commons.validator.ValidatorResults;

import java.io.InputStream;
import java.util.Map;

public class demo {

    static class Name {
        private String huaming;

        private String gonghao;

        public String getHuaming() {
            return huaming;
        }

        public void setHuaming(String huaming) {
            this.huaming = huaming;
        }

        public String getGonghao() {
            return gonghao;
        }

        public void setGonghao(String gonghao) {
            this.gonghao = gonghao;
        }
    }

    public static void main(String[] args) throws Exception{

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        InputStream in = contextClassLoader.getResourceAsStream("validation/commons-validator.xml");

// Create an instance of ValidatorResources to initialize from an xml file.
        ValidatorResources resources = new ValidatorResources(in);
// Create bean to run test on.
        Name name = new Name();

// Construct validator based on the loaded resources and the form key
        Validator validator = new Validator(resources, "nameForm");
// add the name bean to the validator as a resource
// for the validations to be performed on.
        validator.setParameter(Validator.BEAN_PARAM, name);

// Get results of the validation.
        ValidatorResults results = validator.validate();


        if (results.getValidatorResult("firstName") == null) {
            // no error
        } else {
            // number of errors for first name
            //int errors = ((Integer)results.get("firstName")).intValue();
        }

        ValidatorResult result = results.getValidatorResult("gonghao");

        System.out.println(result.getResult("yidaValidateRule"));


    }
}
