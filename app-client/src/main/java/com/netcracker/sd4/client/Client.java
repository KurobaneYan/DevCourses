package com.netcracker.sd4.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class Client {
    public <T, B> ResponseEntity<T> process(Link link, Class<T> tClass, B body) {
        // Set the Accept header
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Add the Jackson message converter
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity<B> requestEntity;
        if (body == null) {
            requestEntity = new HttpEntity<B>(requestHeaders);
        } else {
            requestEntity = new HttpEntity<B>(body, requestHeaders);
        }

        return restTemplate.exchange(link.getLink(), link.getMethod(), requestEntity, tClass);
    }
}