package com.netcracker.sd4.portlet;

import com.liferay.portal.kernel.util.ReleaseInfo;
import com.netcracker.sd4.client.Client;
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
    private Client client;

	@RenderMapping
	public String question(Model model) {
		model.addAttribute("releaseInfo", ReleaseInfo.getReleaseInfo());

        ResponseEntity<String> weather = client.process(Link.GET_WEATHER, String.class, null);
        model.addAttribute("weather", weather.getBody());

		return "app-portlet/view";
	}

	@Autowired
    public void setClient(Client client) {
        this.client = client;
    }
}