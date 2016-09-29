package com.wasadc.common.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;

/**
 * @author Juliano Cassoli
 *
 */
public class MyAppInitializer implements WebApplicationInitializer {

	private static final Logger logger = LogManager.getLogger(MyAppInitializer.class);
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// Some useful information
		logger.info("Your Application version 1.0.0");
		logger.info("OS: " + System.getProperty("os.name") + ", version " + System.getProperty("os.version")
			+ ", Archtecture " + System.getProperty("os.arch"));
		logger.info("Processors: " + Runtime.getRuntime().availableProcessors());

	}

}
