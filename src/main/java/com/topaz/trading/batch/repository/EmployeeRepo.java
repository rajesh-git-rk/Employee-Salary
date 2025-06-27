package com.topaz.trading.batch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.topaz.trading.batch.model.Employees;



public interface EmployeeRepo extends JpaRepository<Employees, Long>{

	Optional<Employees> findById(Long id); 

}
