/**
 * 
 */
package com.wasadc.domain.crud;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wasadc.domain.Employee;

/**
 * @author Juliano Cassoli
 *
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	long countByDepartmentId(Long id);
	
}
