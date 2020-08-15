package com.mx.demo.service;

import com.mx.demo.properties.MxProperties;

public class MxService {
    private String host;
    private String port;

    public MxService(MxProperties mxProperties) {
        this.host = mxProperties.getHost();
        this.port = mxProperties.getPort();
    }

    public void print() {
        System.out.println(this.host + ":" + this.port);
    }
}
