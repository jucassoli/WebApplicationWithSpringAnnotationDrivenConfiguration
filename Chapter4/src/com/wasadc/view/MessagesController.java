/**
 * 
 */
package com.wasadc.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Juliano Cassoli
 *
 */
@Controller
public class MessagesController {

	@RequestMapping("/getMessage")
	public String processShare(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		return "message/showMessage";
	}
	
}
