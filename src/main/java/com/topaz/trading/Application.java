package com.topaz.trading;


import java.util.Date;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.topaz.trading.batch.model.Employees;


//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Configuration
@EnableBatchProcessing
@ComponentScan(basePackages ="com.topaz.trading.batch.*")  
@EntityScan(basePackages = "com.topaz.trading.batch.model")
@EnableJpaRepositories(basePackages="com.topaz.trading.batch.repository")
@EnableScheduling
@SpringBootApplication
public class Application  extends SpringBootServletInitializer {
		
	private static Class<Application> applicationClass = Application.class;

	    public static void main(String[] args) 
	    {
	        SpringApplication.run(applicationClass, args);
	        
	        System.out.println("Welcome Trade Market......");
	    }

		private long millis;

	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(applicationClass);
	    }
	    
	    
	   public class DatabaseConfig {    	

	           @Bean
	           public DataSource dataSource(){
	              DriverManagerDataSource dataSource = new DriverManagerDataSource();
	              dataSource.setDriverClassName("org.postgresql.Driver");
	              dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
	              dataSource.setUsername( "postgres" );
	              dataSource.setPassword( "1234" );
	              return dataSource;
	           }
	    }
	    
}
//	    @Scheduled(initialDelay=1000L, fixedDelayString="${someJob.delay}") 
//	    @Scheduled(initialDelay=1000L, fixedRate=2000L)
	    //crontab.guru-->Link
//	    @Scheduled(cron="*/10 * * * * *") 
//	    void someJob() throws InterruptedException {
//	    	System.out.println("Nos is : "+new Date());
//	    		{
//	    			Thread.sleep(millis);    	
//	    
//	    }
//	    		
	    
//	    @Configuration
//	    @EnableScheduling
//	    @ConditionalOnProperty(name="Scheduling.enabled",matchIfMissing=true)
//	    class SchedulingConfiguration{
//	    	
//	    }
	    
	   
	    
