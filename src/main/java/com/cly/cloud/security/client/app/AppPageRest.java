package com.cly.cloud.security.client.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class AppPageRest {

	@RequestMapping(value = {"/","/index","/welcome","/authTest"},method = RequestMethod.GET)
	public String welcome() {
		return "authTest";
	}

	@RequestMapping(value = "/pages/{page}", method = RequestMethod.GET)
	public String pages(@PathVariable String page) {

	 		return page;
	}

}
