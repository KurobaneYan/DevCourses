package com.netcracker.sd4.client;

import org.springframework.http.ResponseEntity;

public interface WeatherClient extends Client {
    <T> ResponseEntity<T> getWeather(Class<T> tClass);
}
