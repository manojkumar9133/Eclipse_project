package com.manoj.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="demo_table")
public class DemoTable {
	
	
	public DemoTable(){
		
	}
	
	
	
	
	



	public DemoTable(String demoName, String demoNo, String demoClass, String demoId) {
		this.demoName = demoName;
		this.demoNo = demoNo;
		this.demoClass = demoClass;
		this.demoId = demoId;
	}








	@Column(name="demo_name")
	private String demoName;
	
	@Column(name="demo_no")
	private String demoNo;
	
	@Column(name="demo_class")
	private String demoClass;
	
	@Id
	private String demoId;

	public String getDemoName() {
		return demoName;
	}

	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}

	public String getDemoNo() {
		return demoNo;
	}

	public void setDemoNo(String demoNo) {
		this.demoNo = demoNo;
	}

	public String getDemoClass() {
		return demoClass;
	}

	public void setDemoClass(String demoClass) {
		this.demoClass = demoClass;
	}

	public String getDemoId() {
		return demoId;
	}

	public void setDemoId(String demoId) {
		this.demoId = demoId;
	}








	@Override
	public String toString() {
		return "DemoTable [demoName=" + demoName + ", demoNo=" + demoNo + ", demoClass=" + demoClass + ", demoId="
				+ demoId + "]";
	}
	
	
	
	
	
	
	

}
