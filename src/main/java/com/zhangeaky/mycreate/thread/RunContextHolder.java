package com.zhangeaky.mycreate.thread;

public final class RunContextHolder {

    private static final ThreadLocal<RunContext> local = new ThreadLocal<>();

    private RunContextHolder() {}

    public static void set(RunContext context) {
        local.set(context);
    }

    public static RunContext get() {
        return   local.get();
    }

    public static void clear() {
        local.remove();
    }
}
