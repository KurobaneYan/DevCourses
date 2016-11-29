package com.netcracker.sd4;

import com.liferay.portal.kernel.util.ReleaseInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {

	@RenderMapping
	public String question(Model model) {
		model.addAttribute("releaseInfo", ReleaseInfo.getReleaseInfo());

		return "app-portlet/view";
	}

}