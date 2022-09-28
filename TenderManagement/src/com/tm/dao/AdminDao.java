package com.tm.dao;

import com.tm.beans.AdminData;
import com.tm.exceptions.LoginException;

public interface AdminDao {
	
	public String newAdminRegistertoDB(AdminData admindata);
	
	public AdminData adminLoginForm(String username, String password) throws LoginException;

}
