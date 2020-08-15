package com.mx.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

// 绑定配置文件中以“example.mx”为前缀的配置项
@ConfigurationProperties("example.mx")
public class MxProperties {
    private String host;
    private String port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
