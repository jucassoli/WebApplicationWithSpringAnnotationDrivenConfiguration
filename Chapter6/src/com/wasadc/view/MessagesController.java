/**
 * 
 */
package com.wasadc.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wasadc.text.MessageService;

/**
 * @author Juliano Cassoli
 *
 */
@Controller
public class MessagesController {

	@Autowired
	private MessageService mServ;
	
	@RequestMapping("/getMessage")
	public ModelAndView processShare(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String message = mServ.createTextMessage("Vincent");
		
		return new ModelAndView("message/showMessage", "msg", message);
	}
	
}
