package com.tm.beans;

public class ClientsData {
	
	private int sr_no;
	
	private String client_uid;
	
	private String client_name;
	
	private String client_email;
	
	private String client_mobile;
	
	private String client_password;
	
	private String country;

	public int getSr_no() {
		return sr_no;
	}

	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
	}

	public String getClient_uid() {
		return client_uid;
	}

	public void setClient_uid(String client_uid) {
		this.client_uid = client_uid;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getClient_email() {
		return client_email;
	}

	public void setClient_email(String client_email) {
		this.client_email = client_email;
	}

	public String getClient_mobile() {
		return client_mobile;
	}

	public void setClient_mobile(String client_mobile) {
		this.client_mobile = client_mobile;
	}

	public String getClient_password() {
		return client_password;
	}

	public void setClient_password(String client_password) {
		this.client_password = client_password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public ClientsData() {
		
	}
	

	public ClientsData(int sr_no, String client_uid, String client_name, String client_email, String client_mobile,
			String client_password, String country) {
		super();
		this.sr_no = sr_no;
		this.client_uid = client_uid;
		this.client_name = client_name;
		this.client_email = client_email;
		this.client_mobile = client_mobile;
		this.client_password = client_password;
		this.country = country;
	}

	@Override
	public String toString() {
		return "ClientsData [sr_no=" + sr_no + ", client_uid=" + client_uid + ", client_name=" + client_name
				+ ", client_email=" + client_email + ", client_mobile=" + client_mobile + ", client_password="
				+ client_password + ", country=" + country + "]";
	}
	
	
	
	
	

}
