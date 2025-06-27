package com.topaz.trading.batch.config;

import java.util.List;

import org.hibernate.jpa.criteria.expression.function.AggregationFunction.SUM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.topaz.trading.batch.dao.Empdao;
import com.topaz.trading.batch.model.Employees;


@Component
@Configuration
@EnableScheduling
public class SalaryScheduler {
	
	
	
	@Autowired
	Empdao empdao;
	
	
	
	/* @Configuration
	    @EnableScheduling
	    @ConditionalOnProperty(name="Scheduling.enabled",matchIfMissing=true)
	    class SchedulingConfiguration{
	    	
	    }*/
	 
	@Scheduled(cron = "*/10 * * * * * ")
//	    @Scheduled(initialDelay=1000L, fixedRate=2000L)
//    @Scheduled(initialDelay=1000L, fixedDelayString="${updateEmployeeSalary.delay}") 
	 private void updateEmployeeSalary()
	 {
		Long Maxvalue=(long) 50000;
		Long Addvalue=(long) 10000;
		List<Object[]> customersalarylist=empdao.getAllemployeesMaxSalaryIds(Maxvalue);
		System.out.println("size---"+customersalarylist.size());
		
		if(customersalarylist.size()>0) {
			for (int i = 0; i < customersalarylist.size(); i++) {
				if(customersalarylist.get(i)[0]!=null) {
					System.out.println(""+customersalarylist.get(i)[0].toString()+" salary--"+customersalarylist.get(i)[1].toString()); 
//					List<Object[]>updatecustomersalaryById=empdao.getsinglemployeesalarydetailsbyId(customersalarylist.get(i)[0]);
				     Long  Addingtwovalues = Long.sum(Addvalue, (long) customersalarylist.get(i)[1]);  
				     	System.out.println("Addingtwovalues "+Addingtwovalues); 
						int empsalaryID=empdao.updatesalarybyIds(customersalarylist.get(i)[0],Addingtwovalues,customersalarylist.get(i)[1]);

						System.out.println("empsalaryID----"+empsalaryID);
						
				}
				
				
				
			}
		}
	 }

}
