package com.netcracker.sd4.rest.controllers;

import hello.wsdl.GetCityForecastByZIPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import weather.WeatherClient;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private WeatherClient weatherClient;

    @Autowired
    public WeatherController(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String get() {
        String zipCode = "94304";
        GetCityForecastByZIPResponse response = weatherClient.getCityForecastByZIP(zipCode);
        weatherClient.printResponse(response);
        return zipCode;
    }
}
