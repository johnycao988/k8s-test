package com.cly.cloud.security.client.app;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;
import com.cly.comm.client.config.ConfigClient;
import com.cly.logging.LoggingManager;
import com.cly.security.ClientSecurityServiceManager;

@SpringBootApplication(scanBasePackages = "com.cly.cloud.security.client.app")
@ServletComponentScan
public class Application {

	@Autowired

	private Environment env;

	private static Application app;

	public static void init(Application app) {

		Application.app = app;

		refresh();

	}

	public static void refresh() {

		ClientAppProperties cap = new ClientAppProperties(app.env);

		ConfigClient.init(cap);

		try {

			DOMConfigurator
					.configure(ConfigClient.getDocuement("cloud.security.client.log4j.xml").getDocumentElement());
			
			ClientSecurityServiceManager.init(ConfigClient.getProperties("cloud.security.client.properties"));
			

		} catch (Exception e) {

			LoggingManager.systemErr(e);

		}

	}

	public static void main(String[] args) {

		Application app = SpringApplication.run(Application.class, args).getBean(Application.class);

		Application.init(app);

	}

	public static Logger getLogger() {

		Logger logger = LoggingManager.getLogger("cloud.security.client");

		return logger;

	}

}
