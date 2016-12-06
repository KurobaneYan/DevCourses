package com.netcracker.sd4.client.Impl;

import com.netcracker.sd4.client.Link;
import com.netcracker.sd4.client.WeatherClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class WeatherClientImpl extends ClientImpl implements WeatherClient {
    @Override
    public <T> ResponseEntity<T> getWeather(Class<T> tClass) {
        return processURL(Link.GET_WEATHER.getLink(), Link.GET_WEATHER.getMethod(), tClass, null);
    }
}
