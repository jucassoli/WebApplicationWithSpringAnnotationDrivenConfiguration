/**
 * 
 */
package com.wasadc.domain.crud;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wasadc.domain.Department;

/**
 * @author Juliano Cassoli
 *
 */
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {

}
