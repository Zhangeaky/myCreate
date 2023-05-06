package com.zhangeaky.mycreate.thread;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadLocalController {
    static class Request {
        String id;

        String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @RequestMapping("/t1")
    String test01(@RequestBody Request request) throws Exception{

        RunContext context = new RunContext();
        context.setId(request.getId());
        context.setName(request.getName());
        context.setNum(Thread.currentThread().getName());
        RunContextHolder.set(context);
        String x =  RunContextHolder.get().toString();
        Thread.sleep(10_000);
        RunContextHolder.clear();
        //RunContextHolderr
        return x;
    }

    @RequestMapping("/peek")
    String test02() {

        RunContext context = RunContextHolder.get();
        return context.toString();
    }

}
