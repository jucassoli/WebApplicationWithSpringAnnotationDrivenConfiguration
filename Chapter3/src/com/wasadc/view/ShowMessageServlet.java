/**
 * 
 */
package com.wasadc.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wasadc.calc.CalculationService;
import com.wasadc.text.MessageService;

/**
 * @author Juliano Cassoli
 *
 */
@WebServlet(urlPatterns = { "/show" })
public class ShowMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 6621205430874548238L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get spring context from the web application context
		WebApplicationContext springContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		
		// Obtain service instance
		MessageService mServ = springContext.getBean(MessageService.class);
		CalculationService cServ = springContext.getBean(CalculationService.class);
		
		String calcResult = "" + cServ.sum(2, 5); 
		
		response.getWriter().append("Service responded: ").append(mServ.createTextMessage("John"))
			.append(", calc: ").append(calcResult);
		
	}

	
}
