package com.netcracker.sd4.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public enum Company {
        EBAY(30), PAYPAL(10), GOOGLE(15), YAHOO(20), ATT(25);
        private int value;

        Company(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args){
        LOGGER.info("Hello world!");
        LOGGER.info(String.valueOf(Company.EBAY));
        LOGGER.info(String.valueOf(Company.ATT.value));

        String restServer = "http://localhost:8080/";
        // Set the Accept header
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Add the Jackson message converter
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        // Make the HTTP GET request, marshaling the response from JSON to String
        ResponseEntity<String> responseEntity = restTemplate.exchange(restServer + "weather/", HttpMethod.GET, requestEntity, String.class);
        String weatherResponse = responseEntity.getBody();
        LOGGER.info(weatherResponse);

        ResponseEntity<List> responseEntity2 = restTemplate.exchange(restServer + "user/", HttpMethod.GET, requestEntity, List.class);
        List userResponse = responseEntity2.getBody();
        LOGGER.info(userResponse.get(0).toString());
    }
}
