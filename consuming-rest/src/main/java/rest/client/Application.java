package rest.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        LOGGER.info(quote.toString());

        String city = "Minsk";
        String appid = "8c4f6b13bec022d5469715859e68bbc3";

        String weather = restTemplate
                .getForObject("http://api.openweathermap.org/data/2.5/weather?q=" +
                        city + "&appid=" + appid, String.class);

        LOGGER.info(weather);


        Map<String, Object> result = (Map<String, Object>) restTemplate
                .getForObject("http://api.openweathermap.org/data/2.5/weather?q=" +
                        city + "&appid=" + appid + "&units=metric&lang=ru", Map.class);

        Double temperature = (Double) ((Map<String, Object>) result.get("main")).get("temp");

        LOGGER.info(temperature.toString());
        LOGGER.info("");
        LOGGER.info(result.toString());
    }
}
