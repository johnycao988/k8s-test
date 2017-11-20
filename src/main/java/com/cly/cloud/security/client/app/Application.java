package com.cly.cloud.security.client.app;   
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan; 

@SpringBootApplication(scanBasePackages = "com.cly.cloud.security.client.app")
@ServletComponentScan
public class Application {

  

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args).getBean(Application.class); 
	 
	} 

}
