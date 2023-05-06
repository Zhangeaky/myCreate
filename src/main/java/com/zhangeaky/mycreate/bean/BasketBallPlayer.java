package com.zhangeaky.mycreate.bean;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("yilai")
public class BasketBallPlayer extends Person{
}
