package com.wasadc.common.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Juliano Cassoli
 *
 */
public class MyAppInitializer implements WebApplicationInitializer {

	private static final Logger logger = LogManager.getLogger(MyAppInitializer.class);
	
	public static final String CONFIG_PACKAGE = "com.wasadc.common.init";
	public static final String DISPATCHER_MAPPING = "/s/*";
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// Some useful information
		logger.info("Chapter 4 Example version 1.0.0");
		logger.info("OS: " + System.getProperty("os.name") + ", version " + System.getProperty("os.version")
			+ ", Archtecture " + System.getProperty("os.arch"));
		logger.info("Processors: " + Runtime.getRuntime().availableProcessors());

		// Initiate Spring context and scan for services annotated
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_PACKAGE);
        servletContext.addListener(new ContextLoaderListener(context));
        
        // Dispatcher for all controller mappings
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", 
        		new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(DISPATCHER_MAPPING);
	}

}
