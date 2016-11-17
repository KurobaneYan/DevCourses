package rest.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class MyRestClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyRestClient.class);

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        List users = restTemplate.getForObject("http://localhost:8080/user", List.class);
        LOGGER.info("users: " + users);
        LOGGER.info(users.get(0).toString());
        LOGGER.info(users.get(0).getClass().toString());

        List cars = restTemplate.getForObject("http://localhost:8080/cars", List.class);
        LOGGER.info("cars: " + cars);
    }
}
