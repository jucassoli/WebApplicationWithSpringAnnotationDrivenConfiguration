/**
 * 
 */
package com.wasadc.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wasadc.text.MessageService;

/**
 * @author Juliano Cassoli
 *
 */
@Controller
public class MyRestMessageController {

	private static final Logger logger = LogManager.getLogger(MyRestMessageController.class);
	
	@Autowired
	private MessageService mServ;
	
	@RequestMapping(value="/mymess", produces = "application/json")
	@ResponseBody
	public MessageInfo processMessage() {
		
		String message = mServ.createTextMessage("Richard");
		
		MessageInfo mi = new MessageInfo();
		mi.setMessage(message);
		mi.setName("John");
		mi.setNumber(13);
		
		logger.info("Got my message processed here");
		
		return mi;
	}
}
