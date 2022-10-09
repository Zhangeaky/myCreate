package com.zhangeaky.mycreate;

import com.zhangeaky.mycreate.annotations.ZhangEaky;
import com.zhangeaky.mycreate.enums.JobEnum;
import org.springframework.beans.factory.InitializingBean;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

// @ZhangEaky(job = JobEnum.PROGRAMMER)
@ZhangEaky(job = JobEnum.PROGRAMMER)
@NotNull
public class ServiceMonitor implements InitializingBean {

    public final HashMap<String, Long> requestCounterMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[log]" + " " + this.getClass());
    }
}
