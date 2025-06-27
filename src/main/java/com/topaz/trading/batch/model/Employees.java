package com.topaz.trading.batch.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="employees")
public class Employees {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String Empname;
	
	@Column(name="Address")
	private String Address;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="salary")
	private long salary;
	
	
	
	
	
	@Override
	public String toString() {
		return "Employees [Empname=" + Empname + ", Address=" + Address + ", mobile=" + mobile + ", salary=" + salary
				+ "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmpname() {
		return Empname;
	}
	public void setEmpname(String empname) {
		Empname = empname;
	}
	public Employees() {
		super();
	}
	public Employees(String empname, String address, String mobile) {
		super();
		Empname = empname;
		Address = address;
		this.mobile = mobile;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public void add(List<List<Employees>> asList) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
