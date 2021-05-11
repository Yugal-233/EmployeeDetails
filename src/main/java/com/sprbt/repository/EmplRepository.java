package com.sprbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprbt.entity.Employee;

public interface EmplRepository extends JpaRepository<Employee, Integer>{
	
	Employee findByName(String name);

}
