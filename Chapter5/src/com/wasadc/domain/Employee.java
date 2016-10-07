/**
 * 
 */
package com.wasadc.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Juliano Cassoli
 *
 */
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=128, nullable=false)
	private String firstName;
	
	@Column(length=128, nullable=false)
	private String lastName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar hireDate;
	
	@ManyToOne
	private Department department;
	
	@OneToMany(mappedBy="employee", orphanRemoval=true)
	private List<Dependant> dependants;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Dependant> getDependants() {
		return dependants;
	}

	public void setDependants(List<Dependant> dependants) {
		this.dependants = dependants;
	}

	
}
