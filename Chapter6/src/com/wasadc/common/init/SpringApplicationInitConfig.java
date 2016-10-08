/**
 * 
 */
package com.wasadc.common.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;

/**
 * @author Juliano Cassoli
 *
 */
@Configuration
@ComponentScan(basePackages = "com.wasadc")
public class SpringApplicationInitConfig implements ApplicationListener<ApplicationEvent> {

	private static final Logger logger = LogManager.getLogger(SpringApplicationInitConfig.class);
	
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
	
	/**
	 * MBean exporter
	 * 
	 * @return
	 */
	@Bean
	public AnnotationMBeanExporter getMBeanExporter() {
		AnnotationMBeanExporter mbean = new AnnotationMBeanExporter();
		mbean.setAutodetect(true);
		return mbean;
	}

}
