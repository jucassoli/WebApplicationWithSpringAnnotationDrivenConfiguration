/**
 * 
 */
package com.wasadc.view;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wasadc.domain.Department;
import com.wasadc.domain.crud.DepartmentRepository;
import com.wasadc.domain.crud.EmployeeRepository;

/**
 * @author Juliano Cassoli
 *
 */
@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departRep;
	
	@Autowired
	private EmployeeRepository empRep;
	
	@Autowired
	private EntityManager em;
	
	@RequestMapping("/addDepartment")
	public String addDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		return "employee/addUpdateDepartment";
	}
	
	@RequestMapping("/saveDepartment")
	public String saveDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		
		if(name!=null && !name.isEmpty()) {
			Department department = new Department();
			department.setName(name);
			department.setDescript(desc);
			
			departRep.save(department);
		}
		
		return "employee/crudEmployee";
	}
	
	@RequestMapping("/department")
	public String department(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return "employee/crudEmployee";
	}
	
	@RequestMapping("/listDepartment")
	public ModelAndView listDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CriteriaBuilder cbuilder = em.getCriteriaBuilder();
		CriteriaQuery<Department> query = cbuilder.createQuery(Department.class);
		Root<Department> from = query.from(Department.class);
		
		TypedQuery<Department> typedQuery = em.createQuery(query);
		List<Department> resultList = typedQuery.getResultList();
		
		return new ModelAndView("employee/listDepartment", "allDepartment", resultList);
	}
	
	@RequestMapping("/deleteDepartment")
	public String deleteDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String departId = request.getParameter("departId");
		if(departId!=null) {
			Long dId = new Long(departId);
			
			long countExistingEmps = empRep.countByDepartmentId(dId);
			if(countExistingEmps>0) {
				return "employee/cannotDeleteDepartment";
			} else {
				departRep.delete(new Long(departId));
			}
			
		}

		return "employee/crudEmployee";
	}

}
