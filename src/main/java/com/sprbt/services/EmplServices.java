package com.sprbt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprbt.entity.Employee;
import com.sprbt.repository.EmplRepository;

@Service
public class EmplServices {
	
	@Autowired
	private EmplRepository emplRepository;
	
	public List<Employee> getEmplList(){
		
		return emplRepository.findAll();
	}
	
	public Employee getEmplById(int id) {
		
		return emplRepository.findById(id).orElse(null);
	}
	
	public Employee saveEmpl(Employee employee) {
		
		return emplRepository.save(employee);
	}
	
	public List<Employee> saveEmpls(List<Employee> emplList){
		
		return emplRepository.saveAll(emplList);
	}
	
	public Employee getProductByName(String name) {

		return emplRepository.findByName(name);

	}
	
	public int deleteEmpl(int id) {
		
		emplRepository.deleteById(id);
		return id;
	}
	
	public Employee updateEmpl(Employee empl) {
		
		Employee exstEmpl = emplRepository.findById(empl.getId()).orElse(null);
		exstEmpl.setName(empl.getName());
		exstEmpl.setRole(empl.getRole());
		
		return emplRepository.save(exstEmpl);
	}
	
}
