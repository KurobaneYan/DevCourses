package com.netcracker.sd4.portlet.app;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.netcracker.sd4.client.CarClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {

	private static final Logger logger = Logger.getLogger(PortletViewController.class);
    private final int pageSize = 10;

	private CarClient client;

	@RenderMapping
	public String render(Model model) {
		ResponseEntity<Long> carsCountResponseEntity = client.getCarsCount();
		ResponseEntity<List> carsResponseEntity = client.getDefaultCarsPagination(1, List.class);

        if ((carsResponseEntity == null) || (carsCountResponseEntity == null)) {
        	model.addAttribute("errorMessage", "Could not connect to rest server");
        	return "app-portlet/error";
		}

		long pagesCount = carsCountResponseEntity.getBody() / pageSize + 1;
		model.addAttribute("count", pagesCount);
		model.addAttribute("cars", carsResponseEntity.getBody());
		return "app-portlet/app-portlet";
	}

	@ResourceMapping(value = "getCarPagination")
	public void getCarPagination(ResourceResponse resourceResponse, @RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
		ResponseEntity<String> cars = client.getCarsPagination(pageNumber, pageSize, String.class);

		if (cars != null) {
		    try {
			    JSONArray jsonArray = JSONFactoryUtil.createJSONArray(cars.getBody());
			    resourceResponse.setContentType("text/json");
			    resourceResponse.getWriter().write(jsonArray.toString());
		    } catch (IOException | JSONException e) {
                logger.info(e.getMessage());
            }
		}
	}

	@Autowired
	public void setClient(CarClient client) {
		this.client = client;
	}
}