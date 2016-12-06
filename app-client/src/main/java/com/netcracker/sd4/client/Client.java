package com.netcracker.sd4.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface Client {
    <T, B> ResponseEntity<T> process(Link link, Class<T> tClass, B body);
    <T, B> ResponseEntity<T> processURL(String url, HttpMethod method, Class<T> tClass, B body);
}
