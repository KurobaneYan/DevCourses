package com.netcracker.sd4.portlet.weather;

import com.netcracker.sd4.client.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {
	private WeatherClient weatherClient;

	@RenderMapping
	public String render(Model model) {
        ResponseEntity<Map> weather = weatherClient.getWeather(Map.class);

        if (weather == null) {
            model.addAttribute("errorMessage", "Could not retrieve data");
            return "app-portlet/error";
        }

        Map weatherBody = weather.getBody();
        String cityName = (String) weatherBody.get("name");
        Map weatherMain = (Map) weatherBody.get("main");
        double temp = ((Number) weatherMain.get("temp")).doubleValue();
        int pressure = (int) weatherMain.get("pressure");
        int humidity = (int) weatherMain.get("humidity");
        String description = (String) ((Map)((ArrayList) weatherBody.get("weather")).get(0)).get("description");

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("temp", temp);
        attributes.put("cityName", cityName);
        attributes.put("description", description);
        attributes.put("pressure", pressure);
        attributes.put("humidity", humidity);
        model.addAllAttributes(attributes);
        return "app-portlet/weather-portlet";
	}

	@Autowired
	public void setWeatherClient(WeatherClient weatherClient) {
		this.weatherClient = weatherClient;
	}
}