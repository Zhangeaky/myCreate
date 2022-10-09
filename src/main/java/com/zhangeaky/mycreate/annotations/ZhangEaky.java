package com.zhangeaky.mycreate.annotations;


import com.zhangeaky.mycreate.enums.JobEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ZhangEaky {

    JobEnum job();
}
