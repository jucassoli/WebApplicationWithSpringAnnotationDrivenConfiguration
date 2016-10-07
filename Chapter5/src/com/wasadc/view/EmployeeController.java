/**
 * 
 */
package com.wasadc.view;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wasadc.domain.Department;
import com.wasadc.domain.Dependant;
import com.wasadc.domain.DependantType;
import com.wasadc.domain.Employee;
import com.wasadc.domain.crud.DepartmentRepository;
import com.wasadc.domain.crud.DependantRepository;
import com.wasadc.domain.crud.EmployeeRepository;

/**
 * @author Juliano Cassoli
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRep;
	
	@Autowired
	private DependantRepository depRep;
	
	@Autowired
	private DepartmentRepository departRep;
	
	
	@RequestMapping("/employee")
	public String crudEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		return "employee/crudEmployee";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Iterable<Department> allDepartment = departRep.findAll();
		request.setAttribute("departments", allDepartment);
		
		return "employee/addUpdateEmployee";
	}
	
	@RequestMapping("/saveEmployee")
	public String saveEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String departmentIdSelection = request.getParameter("departmentIdSelection");
		
		String dependantName1 = request.getParameter("dependantName1");
		String dependant1Selection = request.getParameter("dependant1Selection");

		String dependantName2 = request.getParameter("dependantName2");
		String dependant2Selection = request.getParameter("dependant2Selection");

		if(firstName!=null && lastName!=null && !firstName.isEmpty() && !lastName.isEmpty()) {
			
			Employee employee = new Employee();
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setHireDate(Calendar.getInstance());
			
			if(!departmentIdSelection.equals("no_selection")) {
				Department departFound = departRep.findOne(Long.parseLong(departmentIdSelection));
				employee.setDepartment(departFound);
			}
			
			empRep.save(employee);
			
			if(dependantName1!=null && !dependantName1.isEmpty()) {
				Dependant dependant = new Dependant();
				dependant.setName(dependantName1);
				dependant.setEmployee(employee);
				dependant.setType(DependantType.valueOf(dependant1Selection));
				depRep.save(dependant);
			}
			
			if(dependantName2!=null && !dependantName2.isEmpty()) {
				Dependant dependant = new Dependant();
				dependant.setName(dependantName2);
				dependant.setEmployee(employee);
				dependant.setType(DependantType.valueOf(dependant2Selection));
				depRep.save(dependant);
			}
			
		}
		
		return "employee/crudEmployee";
	}

	@RequestMapping("/listEmployee")
	public ModelAndView listEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Iterable<Employee> employeeList = empRep.findAll();
		
		return new ModelAndView("employee/listEmployee", "mylist", employeeList);
	}
	
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String empId = request.getParameter("employeeId");
		if(empId!=null) {
			empRep.delete(new Long(empId));
		}

		return "employee/crudEmployee";
	}
	
}
