/**
 * 
 */
package com.wasadc.text;

import org.springframework.jmx.export.annotation.ManagedMetric;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.support.MetricType;
import org.springframework.stereotype.Service;

/**
 * @author Juliano Cassoli
 *
 */
@Service
@ManagedResource(objectName = "MyApp:name=MessageService")
public class MessageServiceImpl implements MessageService {

	private volatile long callCount;
	
	private volatile boolean interruptCount;
		
	/* (non-Javadoc)
	 * @see com.wasadc.text.MessageService#createTextMessage(java.lang.String)
	 */
	@Override
	public String createTextMessage(String name) {
		if (!interruptCount) callCount++;
		return "This is my message to " + name;
	}
	
	@ManagedMetric(unit="Messages", description = "Quantity", metricType=MetricType.COUNTER)
	public long getServiceCallCount() {
		return callCount;
	}

	@ManagedOperation(description = "Interrupt the count")
	public void interruptCount() {
		interruptCount = true;
	}
	
	@ManagedOperation(description = "Resume the count")
	public void resumeCount() {
		interruptCount = false;
	}
	
	@ManagedOperation(description = "Reset the count")
	public void resetCounter() {
		callCount = 0;
	}
	
}
