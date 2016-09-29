package com.wasadc.common.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author Juliano Cassoli
 *
 */
public class MyAppInitializer implements WebApplicationInitializer {

	private static final Logger logger = LogManager.getLogger(MyAppInitializer.class);
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// Some useful information
		logger.info("Chapter 3 Example version 1.0.0");
		logger.info("OS: " + System.getProperty("os.name") + ", version " + System.getProperty("os.version")
			+ ", Archtecture " + System.getProperty("os.arch"));
		logger.info("Processors: " + Runtime.getRuntime().availableProcessors());

		// Initiate Spring context and scan for services annotated
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.wasadc");
        servletContext.addListener(new ContextLoaderListener(context));
        
	}

}
