package com.netcracker.sd4.portlet;

import com.netcracker.sd4.client.CarClient;
import com.netcracker.sd4.client.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {

	private CarClient client;

	@RenderMapping
	public String render(Model model) {
        ResponseEntity<String> cars = client.process(Link.GET_CARS, String.class, null);

        if (cars != null) {
            model.addAttribute("cars", cars.getBody());
        } else {
            model.addAttribute("cars", "Can't connect to rest server");
        }

		return "app-portlet/view";
	}

	@Autowired
	public void setClient(CarClient client) {
		this.client = client;
	}
}