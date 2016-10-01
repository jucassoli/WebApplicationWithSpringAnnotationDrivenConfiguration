/**
 * 
 */
package com.wasadc.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wasadc.calc.CalculationService;
import com.wasadc.text.MessageService;

/**
 * @author Juliano Cassoli
 *
 */
@Component
public class MessageCalculated {

	@Autowired
	private MessageService mServ;
	
	@Autowired
	private CalculationService cServ;
	
	public String getJoinedServices(String name, int a, int b) {
		return "Message: " + mServ.createTextMessage(name) + ", sum=" + cServ.sum(a, b);
	}
}
