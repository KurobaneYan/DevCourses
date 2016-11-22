package com.netcracker.sd4.client;

import org.springframework.http.HttpMethod;

public enum Link {
    GET_WEATHER ("weather", HttpMethod.GET),
    GET_CARS("cars", HttpMethod.GET);

    private final String url;
    private final HttpMethod method;

    Link(String url, HttpMethod method) {
        this.url = url;
        this.method = method;
    }
    public String getUrl() {
        return this.url;
    }
    public HttpMethod getMethod() {
        return this.method;
    }

    public static final String host = "http://localhost";
    public static final int port = 8000;

    String getLink() {
        return host + ":" + port + "/" + url + "/";
    }
}
