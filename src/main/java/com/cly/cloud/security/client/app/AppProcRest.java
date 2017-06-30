package com.cly.cloud.security.client.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cly.security.ClientSecurityServiceManager;
import com.cly.security.SecurityAuthException;

@Controller

public class AppProcRest {

	@RequestMapping(value = "/authTestProc", method = RequestMethod.POST)
	public String authTestProc(HttpServletRequest request, HttpServletResponse response, ModelMap mv) {

		try {

			String[] permissionNames = { request.getParameter("ROLE_NAME") };

			if (ClientSecurityServiceManager.getClientSecurityFilterService().accessPermmission(request, response,
					permissionNames)) {
				mv.addAttribute("authTestResult", "Auth Test OK.");
			}

		} catch (SecurityAuthException e) {
			Application.getLogger().error("Get Client Security Service error:", e);
		}

		return "authTestResult";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws SecurityAuthException {

		ClientSecurityServiceManager.getClientSecurityFilterService().logout(request, response);
		
		Application.getLogger().info("Logout OK.");
		
		return "logout";

	}

}
