package com.tm.beans;

public class AdminData {
	
	
//	private variables with data type
//	serial_no will be auto increment in database no need to take from user.
	
	private String admin_uid;
	
	private String name;

	private String email;
	
	private String mobile;
	
	private String password;
	
	private String organization;
	
	private String country;
	
	private String state;

	
	
//	Getter and setter methods for above private variables to use outside package
	

	public String getAdmin_uid() {
		return admin_uid;
	}

	public void setAdmin_uid(String admin_uid) {
		this.admin_uid = admin_uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
	
//	Generating constructor method both parameterized and non-parameterized
	
	
	public AdminData() {
		
	}
	
	
	
	
	public AdminData( String admin_uid, String name, String email, String mobile, String password,
			String organization, String country, String state) {
		super();
		this.admin_uid = admin_uid;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.organization = organization;
		this.country = country;
		this.state = state;
	}
	
//	Overriding to string method  

	@Override
	public String toString() {
		return "AdminRegisterForm [ admin_uid=" + admin_uid + ", name=" + name + ", email="
				+ email + ", mobile=" + mobile + ", password=" + password + ", organization=" + organization
				+ ", country=" + country + ", state=" + state + "]";
	}
	
	
	

}
