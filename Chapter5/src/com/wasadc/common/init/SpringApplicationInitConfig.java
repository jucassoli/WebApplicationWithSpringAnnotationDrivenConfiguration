/**
 * 
 */
package com.wasadc.common.init;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author Juliano Cassoli
 *
 */
@Configuration
@ComponentScan(basePackages = "com.wasadc")
public class SpringApplicationInitConfig implements ApplicationListener<ApplicationEvent> {

	private static final Logger logger = LogManager.getLogger(SpringApplicationInitConfig.class);
	
	public static final String PERSISTENCE_FILE_NAME = "data-source.properties";
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// Bean Manager Started
		if(event instanceof ContextRefreshedEvent) {
			logger.info("Spring Bean Manager Started");
		}

		// Shutting down application
		if(event instanceof ContextClosedEvent) {
			logger.info("Spring context closed.");
		}
	}

	@Bean
	public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer(){
		
		InputStream is = SpringApplicationInitConfig.class.getClassLoader()
				.getResourceAsStream(PERSISTENCE_FILE_NAME);
		
		PropertyPlaceholderConfigurer ppc = null;
		try {
			ppc = new PropertyPlaceholderConfigurer();
			
			Properties propsToPass = new Properties();
			propsToPass.load(is);
			ppc.setProperties(propsToPass);
			ppc.setIgnoreUnresolvablePlaceholders(false);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ppc;
	}
	
}
