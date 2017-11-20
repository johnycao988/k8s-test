package com.cly.cloud.security.client.app; 
 
 
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 
 

@Controller 
@RestController 
public class SysRest {  
 
	@RequestMapping("/version")
	public String getVersion() {
		
		return "K8s test, version v1.0";		
	}
	
	@RequestMapping("/info")
	public String getInfo(HttpServletRequest request, HttpServletResponse response) {
		
		String info=Calendar.getInstance().getTime().toString()+" A request from:"+request.getRemoteAddr()+" to "+request.getLocalAddr();
		
		return info;		
	}
	
	 
	@RequestMapping(value="/reqMSUrl")
	public String reqMSUrl(HttpServletRequest request, HttpServletResponse response, @RequestParam("reqUrl")  String url) throws IOException {
		
		String info=getInfo(request,response) +" request Url:"+url+"\r\n";	
		
		String reqInfo=HttpClient.request(url, HttpClient.REQUEST_METHOD_GET, null);
		
		info+="Response:"+reqInfo+"\r\n";
		
		return info;		
	}
	 

}
