package com.zhangeaky.mycreate.thread;

public class RunContext {

    String name;

    String id;

    String num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "RunContext{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
