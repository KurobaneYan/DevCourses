package com.netcracker.sd4.client.Impl;

import com.netcracker.sd4.client.Client;
import com.netcracker.sd4.client.Link;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class ClientImpl implements Client {
    @Override
    public <T, B> ResponseEntity<T> process(Link link, Class<T> tClass, B body) {
        return processURL(link.getLink(), link.getMethod(), tClass, body);
    }

    @Override
    public <T, B> ResponseEntity<T> processURL(String url, HttpMethod method, Class<T> tClass, B body) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity<B> requestEntity;
        if (body == null) {
            requestEntity = new HttpEntity<B>(requestHeaders);
        } else {
            requestEntity = new HttpEntity<B>(body, requestHeaders);
        }

        ResponseEntity<T> output;
        try {
            output = restTemplate.exchange(url, method, requestEntity, tClass);
        } catch (ResourceAccessException exception) {
            System.err.println(exception);
            return null;
        } catch (Exception e) {
            return null;
        }

        return output;
    }
}
