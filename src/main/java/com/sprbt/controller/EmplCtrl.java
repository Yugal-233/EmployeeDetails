package com.sprbt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprbt.entity.Employee;
import com.sprbt.services.EmplServices;

@RestController
public class EmplCtrl {
	
	@Autowired
	private EmplServices emplServices;
	
	@GetMapping("/getEmpl/{id}")
	public Employee getEmplById(@PathVariable int id) {
		
		return emplServices.getEmplById(id);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmpl(){
		
		return emplServices.getEmplList();
	}
	
	@GetMapping("/emmplByName/{name}")
	public Employee findProductByName(@PathVariable String name) {
		return emplServices.getProductByName(name);
	}
	
	
	@PostMapping("/saveEmpl")
	public Employee saveEmpl(@RequestBody Employee employee) {
		return emplServices.saveEmpl(employee);
	}
	
	@PostMapping("/saveAllEmpl")
	public List<Employee> saveAllEmpl(@RequestBody List<Employee> empl){
		
		return emplServices.saveEmpls(empl);
	}
	
	@DeleteMapping("/deleteEmpl/{id}")
	public String deleteEmplById(@PathVariable int id) {
		
		 emplServices.deleteEmpl(id);
		 return "the delete empl is "+id; 
	}
	
	@PutMapping("/updateEmpl")
	public Employee updateEmpl(@RequestBody Employee empl) {
		
		return emplServices.updateEmpl(empl);
	}

}
