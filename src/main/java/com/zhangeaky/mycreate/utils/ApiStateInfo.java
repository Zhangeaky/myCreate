package com.zhangeaky.mycreate.utils;

public class ApiStateInfo {

    private Api apiInfo;
    private long requestCount;

    public Api getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(Api apiInfo) {
        this.apiInfo = apiInfo;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(long requestCount) {
        this.requestCount = requestCount;
    }
}
