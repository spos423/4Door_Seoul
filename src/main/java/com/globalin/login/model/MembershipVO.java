package com.globalin.login.model;

import java.sql.ResultSet;

public class MembershipVO {

	private String id;
	private String pass;
	private String name;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email;
	private String adminyn;
	

	
	public MembershipVO() {	}
	
	public MembershipVO(
			String id, String pass, String name, String phone1, 
			String phone2, String phone3, String email, String adminyn
			) {
		
		this.id=id;
		this.pass=pass;
		this.name=name;
		this.phone1=phone1;
		this.phone2=phone2;
		this.phone3=phone3;
		this.email=email;
		this.adminyn=adminyn;
	}

	public String getAdminyn() {
		return adminyn;
	}

	public void setAdminyn(String adminyn) {
		this.adminyn = adminyn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}






}
