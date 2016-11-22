package com.netcracker.sd4.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){
        Client client1 = new Client();

        ResponseEntity<String> weather = client1.process(Link.GET_WEATHER, String.class);
        LOGGER.info(weather.toString());
        LOGGER.info(weather.getBody());

        ResponseEntity<List> cars = client1.process(Link.GET_CARS, List.class);
        LOGGER.info(cars.toString());
        LOGGER.info(cars.getBody().get(0).toString());

    }
}
