package com.topaz.trading.batch.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.topaz.trading.batch.model.Employees;


@Service
public interface Empdao {

	List<Employees> getAllemployeedetails();
	 
	Employees getAllemployeesbyId(long id); 
	
	List<Employees> getAllemployeesbyIdd(long id);

	List<Employees> getAllemployeesMaxSalary(long Maxvalue);

	List<Object[]> getAllemployeesMaxSalaryIds(Long maxvalue);


	List<Object[]> getsinglemployeesalarydetailsbyId(Object object);

	int updatesalarybyIds(Object object, Long Addingtwovalues, Object object2); 
	
	

}
