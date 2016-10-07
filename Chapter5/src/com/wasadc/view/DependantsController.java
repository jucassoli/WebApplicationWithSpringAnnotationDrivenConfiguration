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

import com.wasadc.domain.Dependant;
import com.wasadc.domain.crud.DependantRepository;

/**
 * @author Juliano Cassoli
 *
 */
@Controller
public class DependantsController {

	@Autowired
	private DependantRepository depRep;
	
	
	@RequestMapping("/listDependants")
	public ModelAndView listEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Iterable<Dependant> depList = null; 
				
		String empId = request.getParameter("employeeId");
		if(empId!=null) {
			depList = depRep.findByEmployeeId(new Long(empId));
		} else {
			depList = depRep.findAll();
		}
		
		return new ModelAndView("employee/listDependants", "depList", depList);
	}
	
}
