package com.cly.cloud.security.client.app; 
 
 
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cly.comm.util.JSONUtil; 
 

@RestController

public class SysRest { 
	
	@Value("${app.info}")
    private String appInfo;
 
	@RequestMapping("/info")
	public String info() {
		return appInfo;
	}  
	
	@RequestMapping("/refresh")
	public String refreshApp() { 
		 
		Application.getLogger().info("A request coming to Refresh.");
		
		Application.refresh();
		
		return "Refreshed.";
	}

	@RequestMapping("/health")
	public String health() {
		
		Application.getLogger().info("Health check.");
		return JSONUtil.getMSHealthCheckResponse();
	}

}
