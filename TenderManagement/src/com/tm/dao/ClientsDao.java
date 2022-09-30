package com.tm.dao;


import java.util.List;

import com.tm.beans.ClientsData;
import com.tm.beans.TenderAdd;
import com.tm.beans.TenderBids;
import com.tm.exceptions.LoginException;
import com.tm.exceptions.TenderException;

public interface ClientsDao {
	
	public ClientsData ClientRegistrationForm(ClientsData clientdata)throws LoginException;

	public ClientsData clientLoginForm(String userid, String passcode) throws LoginException;
	
	public String clientBidingForm(TenderBids bid);
	
	public List<TenderBids> bidingHistory(String clientId) throws TenderException;
	
	public List<TenderAdd> assignedTenderToClient(String clientId) throws TenderException;

}
