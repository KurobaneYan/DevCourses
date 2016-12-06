import com.netcracker.sd4.client.CarClient;
import com.netcracker.sd4.client.Link;
import com.netcracker.sd4.client.WeatherClient;
import com.netcracker.sd4.client.configuration.RestClientConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RestClientConfiguration.class)
public class CarClientTest {
    private final String jsonUser = "{\n" +
            "    \"name\": \"Alex\",\n" +
            "    \"surname\": \"Chuduk\",\n" +
            "    \"email\": \"a4dix3@gmail.com\",\n" +
            "    \"phoneNumber\": \"+375291142095\",\n" +
            "    \"password\": \"testpassword\"\n" +
            "  }";


    @Autowired
    private CarClient carClient;

    @Autowired
    private WeatherClient weatherClient;

    @Test
    public void testGetWeatherClient() {
        ResponseEntity<String> weather = carClient.process(Link.GET_WEATHER, String.class, null);
        Assert.assertNotNull(weather);
    }

    @Test
    public void testGetCarsList() {
        ResponseEntity<List> cars = carClient.process(Link.GET_CARS, List.class, null);
        Assert.assertNotNull(cars);
    }

    @Test
    public void testCarsPagination() {
        ResponseEntity<List> cars = carClient.getCarsPagination(1, 5, List.class);
        Assert.assertNotNull(cars);
    }

    @Test
    public void testGetUserOrders() {
        ResponseEntity<String> orders = carClient.process(Link.GET_ORDERS, String.class, jsonUser);
        Assert.assertNotNull(orders);
    }

    @Test
    public void testGetWeather() {
        ResponseEntity<String> weather = weatherClient.getWeather(String.class);
        Assert.assertNotNull(weather);
    }
}
