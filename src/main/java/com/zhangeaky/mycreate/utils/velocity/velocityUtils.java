package com.zhangeaky.mycreate.utils.velocity;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

public class velocityUtils {


    public static void test() {

        Velocity.init();
        VelocityContext context = new VelocityContext();
        context.put("name", "yida");
        context.put("age", 18);

        StringWriter writer = new StringWriter();

        Velocity.mergeTemplate("./yida.vm", StandardCharsets.UTF_8.name(), context, writer);
        System.out.println(writer);

    }

    public static void main(String[] args) {
        test();
    }
}
