package com.topaz.trading.batch.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.topaz.trading.batch.dao.Empdao;
import com.topaz.trading.batch.model.Employees;
import com.topaz.trading.batch.repository.EmployeeRepo;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	
	
	
	@Autowired
	 EmployeeRepo employeeRepo;
	
	@Autowired
	Empdao employeedao;
	
	
	
	
	
	@GetMapping("/home")
	public String gethome() {
		return "successfully opened!..";
	}
	
	
	
	
	//getEmployee above 50000 salary
	@SuppressWarnings("unchecked")
	@GetMapping("/employeeSalary")
	public List<Employees> getAllemployeesMaxSalaryList()
	{
		Long Maxvalue=(long) 50000;
		Long AddValue=(long) 10000;
		System.out.println("sssss");		
		  System.out.println("Maxvalue "+Maxvalue); 
		List<Employees> maxSalary=employeedao.getAllemployeesMaxSalary(Maxvalue);

		return maxSalary;
	}

	
	
	//getAll Employees
	@GetMapping("/employees")
	public List<Employees> getAllemployees()
	{
		System.out.println("sssss");		
		return employeedao.getAllemployeedetails();
	}

	
	//Get EmployeeByid
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employees>> getAllemployeesbyid1(@PathVariable(value="id") Long id)  
	{
		Optional<Employees> emp=employeeRepo.findById(id);
		
		return ResponseEntity.ok().body(emp);
				
	}
	
	//Save Employees
			@PostMapping("employees")
		public Employees SaveEmploees(@RequestParam(value="Empname",required=false,defaultValue="")  String Empname,@RequestParam(value="Address",required=false,defaultValue="")
		String Address,@RequestParam(value="mobile",required=false,defaultValue="")  String mobile,
		@RequestParam(value="salary",required=false,defaultValue="")  long salary) {
			
			Employees emp=new Employees();
			emp.setEmpname(Empname);
			emp.setAddress(Address);
			emp.setMobile(mobile);
			emp.setSalary(salary);
			return employeeRepo.save(emp);
			 
	}
			
			
	
	//Update Employees
	@PutMapping("employees/{id}")
	public ResponseEntity<Employees>updateEmployee(@PathVariable(value="id") Long id,@Valid @RequestBody Employees empdetails){
		
 
//		System.out.println("empname"+empdetails.getEmpname()+" addres "+empdetails.getAddress()+" mob "+empdetails.getMobile());
		
		Employees empp=employeedao.getAllemployeesbyId(id);
		
		
		empp.setEmpname(empdetails.getEmpname());
		empp.setAddress(empdetails.getAddress());
		empp.setMobile(empdetails.getMobile());
		empp.setSalary(empdetails.getSalary());
		
		return ResponseEntity.ok(this.employeeRepo.save(empp));
	}
									

//	@DeleteMapping("emplyoees/{id}")
	@RequestMapping(value = "emplyoees/{id}",method=RequestMethod.DELETE)
	public Employees deleteEmployee(@PathVariable (value="id") long id) {
		
		Employees emp=employeeRepo.getOne(id);
		employeeRepo.delete(emp);
		
		return emp;
		
	}

//	@DeleteMapping("emplyoees/{id}")
//	@RequestMapping(value = "emplyoees/{id}", method = RequestMethod.DELETE)
//	public Map<String,Boolean> DeleteEmployees(@PathVariable (value="id")long id)
//	public void removeUserRole(@PathVariable (value="id") long id)
//	{
//		
//		System.out.println("id   "+id);

//		employeeRepo.deleteById(id);

//					employeeRepo.findByid(id);
//		this.employeeRepo.delete(emp);
		
////		Map<String,Boolean> response=new HashMap();
//		response.put("deleted", Boolean.TRUE);
//		
//		return "Deleted!";
		
//	}
	
	
}
