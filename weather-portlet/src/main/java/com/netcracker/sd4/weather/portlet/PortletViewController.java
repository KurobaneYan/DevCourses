package com.netcracker.sd4.weather.portlet;

import com.netcracker.sd4.client.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import java.util.ArrayList;
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
            return "weather portlet/error";
        }

        String description = (String) ((Map)((ArrayList)weather.getBody().get("weather")).get(0)).get("description");
        Integer temp = (Integer) ((Map)weather.getBody().get("main")).get("temp");
        model.addAttribute("description",description);
        model.addAttribute("temp", temp);
        return "weather portlet/view";
	}

	@Autowired
	public void setWeatherClient(WeatherClient weatherClient) {
		this.weatherClient = weatherClient;
	}
}