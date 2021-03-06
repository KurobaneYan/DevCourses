package com.netcracker.sd4.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @SuppressWarnings("unchecked")
    public Map<String, Object> getRestWeather() {
        String city = "Minsk";
        String appid = "8c4f6b13bec022d5469715859e68bbc3";
        Map<String, Object> result = (Map<String, Object>) restTemplate
                .getForObject("http://api.openweathermap.org/data/2.5/weather?q=" +
                        city + "&appid=" + appid + "&units=metric&lang=en", Map.class);
        return result;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
