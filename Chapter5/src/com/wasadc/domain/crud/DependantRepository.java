/**
 * 
 */
package com.wasadc.domain.crud;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wasadc.domain.Dependant;

/**
 * @author Juliano Cassoli
 *
 */
public interface DependantRepository extends PagingAndSortingRepository<Dependant, Long> {

	Iterable<Dependant> findByEmployeeId(Long id);
	
}
