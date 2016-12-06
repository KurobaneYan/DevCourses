package com.netcracker.sd4.client;

import org.springframework.http.HttpMethod;

public enum Link {
    GET_WEATHER ("weather", HttpMethod.GET),
    GET_ORDERS("order/by_user", HttpMethod.POST),
    GET_CARS("car/all", HttpMethod.GET),
    UPDATE_CAR("car/", HttpMethod.PUT),
    CREATE_CAR("car/create", HttpMethod.POST),
    DELETE_CAR("car/", HttpMethod.DELETE);

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

    public String getLink() {
        return host + ":" + port + "/" + url + "/";
    }
}
