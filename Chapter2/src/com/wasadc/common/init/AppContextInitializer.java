package com.wasadc.common.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Juliano Cassoli
 *
 */
@WebListener
public class AppContextInitializer implements ServletContextListener {
	
	private static final Logger logger = LogManager.getLogger(AppContextInitializer.class);

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		logger.info("Servlet context [" + contextEvent.getServletContext().getContextPath() 
				+ "] is closing. Goodbye.");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {

		logger.info("Application context initialized: " + contextEvent.getServletContext().getContextPath());
		
	}

}
