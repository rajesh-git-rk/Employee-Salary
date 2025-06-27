package com.topaz.trading.batch.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.jpa.criteria.expression.function.AggregationFunction.SUM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Repository;

import com.topaz.trading.batch.dao.Empdao;
import com.topaz.trading.batch.model.Employees;





@Repository
@Transactional
@EnableScheduling

public class EmployeedaoImpl implements Empdao {
	
	@Autowired
	@PersistenceContext
	EntityManager entityManager;
	
	

	@Override
	public List<Employees> getAllemployeedetails() {
		List<Employees> list=entityManager.createQuery("from Employees").getResultList();
		return list;
	}
	@Override
	public Employees getAllemployeesbyId(long id) {
		Employees list=(Employees) entityManager.createQuery("from Employees where id=:id").setParameter("id", id).getSingleResult(); 
		return list;
	}

	@Override
	public List<Employees> getAllemployeesbyIdd(long id) {
		List<Employees> list=entityManager.createQuery("from Employees where id=:id").setParameter("id", id).getResultList(); 
		return list;
		
	}
	@Override
	public List<Employees> getAllemployeesMaxSalary(long Maxvalue) {
		List<Employees> list=entityManager.createQuery("from Employees where salary>=:Maxvalue").setParameter("Maxvalue", Maxvalue).getResultList(); 
		return list;
	}
	@Override
	public List<Object[]> getAllemployeesMaxSalaryIds(Long maxvalue) {
		List<Object[]> list=entityManager.createQuery("select id,salary,Empname,Address from Employees where salary>=:Maxvalue").setParameter("Maxvalue", maxvalue).getResultList(); 
		return list;
	}
	
	@Override
	public List<Object[]> getsinglemployeesalarydetailsbyId(Object EmployeeId) {
		List<Object[]> list=entityManager.createQuery("select salary,id from Employees where id=:EmployeeId group by EmployeeId").setParameter("EmployeeId", EmployeeId).getResultList(); 
		return list;
	}
	@Override
	public int updatesalarybyIds(Object Id,Long Addingtwovalues,Object salary) {
		String strAddingtwovalues=Addingtwovalues.toString();
	/*String strsalary=salary.toString();
	String strId=Id.toString();
	Long longId=Long.parseLong(strId);
	Long longsalary=Long.parseLong(strsalary);
	Long longAddingtwovalues=Long.parseLong(strAddingtwovalues);
*///	Query query=entityManager.createNamedQuery("update Employees set salary=:longAddingtwovalues where id=:Id and salary=:salary").setParameter("Id", longId).setParameter("longAddingtwovalues", longAddingtwovalues).setParameter("salary",longsalary);

		Query query=entityManager.createQuery("update Employees set salary=:longAddingtwovalues where id=:Id and salary=:salary").setParameter("Id", Id).setParameter("longAddingtwovalues", Addingtwovalues).setParameter("salary",salary);
		int result=query.executeUpdate();
		return result;
	}
	
}
