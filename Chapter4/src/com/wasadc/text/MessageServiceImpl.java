/**
 * 
 */
package com.wasadc.text;

import org.springframework.stereotype.Service;

/**
 * @author Juliano Cassoli
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	/* (non-Javadoc)
	 * @see com.wasadc.text.MessageService#createTextMessage(java.lang.String)
	 */
	@Override
	public String createTextMessage(String name) {
		return "This is my message to " + name;
	}

}
