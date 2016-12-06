package com.netcracker.sd4.weather.portlet;

import com.netcracker.sd4.client.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {
	private WeatherClient weatherClient;

	@RenderMapping
	public String render(Model model) {
        ResponseEntity<String> weather = weatherClient.getWeather(String.class);

        if (weather != null) {
            model.addAttribute("weather", weather.getBody());
        } else {
            model.addAttribute("weather", "Could not retrieve weather data");
        }
		return "weather portlet/view";
	}

	@Autowired
	public void setWeatherClient(WeatherClient weatherClient) {
		this.weatherClient = weatherClient;
	}
}