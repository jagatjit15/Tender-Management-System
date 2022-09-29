package com.tm.dao;

import com.tm.beans.ClientsData;
import com.tm.exceptions.LoginException;

public interface ClientsDao {
	
	public ClientsData ClientRegistrationForm(ClientsData clientdata)throws LoginException;

}
