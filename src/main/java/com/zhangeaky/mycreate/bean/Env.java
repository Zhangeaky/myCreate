package com.zhangeaky.mycreate.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Env {

    @NotBlank
    private String os;

    @NotBlank
    @Size(max = 10, min = 1)
    private String version;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Env{" +
                "os='" + os + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
