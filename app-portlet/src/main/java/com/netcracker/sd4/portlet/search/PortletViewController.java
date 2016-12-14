package com.netcracker.sd4.portlet.search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {

	@RenderMapping
	public String render(Model model) {
	    //model.addAttribute("errorMessage", "Hello World!");
        //return "app-portlet/error";
		return "app-portlet/search-portlet";
	}

}