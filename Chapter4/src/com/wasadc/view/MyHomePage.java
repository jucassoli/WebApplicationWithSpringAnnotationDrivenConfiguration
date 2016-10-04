/**
 * 
 */
package com.wasadc.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Juliano Cassoli
 *
 */
@Controller
public class MyHomePage {
	
	private static final Logger logger = LogManager.getLogger(MyHomePage.class);
	
	@RequestMapping("/home")
	public String processShare(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		logger.info("process something");
		
		return "home/myHome";
	}

}
