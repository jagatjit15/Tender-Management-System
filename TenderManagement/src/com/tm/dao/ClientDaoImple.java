package com.tm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tm.beans.AdminData;
import com.tm.beans.ClientsData;
import com.tm.beans.TenderAdd;
import com.tm.beans.TenderBids;
import com.tm.exceptions.LoginException;
import com.tm.exceptions.TenderException;
import com.tm.utility.DBUtility;

public class ClientDaoImple implements ClientsDao{
	
	/***************************************************************
	 * New Client registration form                                *
	 * Overriden Method of ClientDao Interface                     *
	 **************************************************************/

	@Override
	public ClientsData ClientRegistrationForm(ClientsData clientdata) throws LoginException {
		
		ClientsData client = new ClientsData();
		
           try(Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into clients(client_uid,client_name, client_email, client_mobile,"
					                                         + "client_password, country)"
					                                         + "values (?,?,?,?,?,?)");
			
			ps.setString(1, clientdata.getClient_uid());
			ps.setString(2, clientdata.getClient_name());
			ps.setString(3, clientdata.getClient_email());
			ps.setString(4, clientdata.getClient_mobile());
			ps.setString(5, clientdata.getClient_password());
			ps.setString(6, clientdata.getCountry());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				
				client.setClient_name(clientdata.getClient_name());
				client.setClient_uid(clientdata.getClient_uid());
				client.setClient_password(clientdata.getClient_password());
				
			}
			else {
				throw new LoginException("Something went wrong....");
			}
			
		
		} catch (SQLException e) {
			
			throw new LoginException(e.getMessage());
			
		}
		
		return client;
	}
	
	
	/***************************************************************
	 * New Client Login form                                       *
	 * Overriden Method of ClientDao Interface                     *
	 **************************************************************/
	

	@Override
	public ClientsData clientLoginForm(String userid, String passcode)throws LoginException {
		
		ClientsData data = new ClientsData();
		
            try(Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from clients where client_uid = ? AND client_password = ?");
			
			ps.setString(1, userid);
			ps.setString(2, passcode);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				data.setClient_name("client_name");
				
			}
			else {
				throw new LoginException("Invalid user_Id or password....");
			}
			
			
			
		} catch (SQLException e) {

			throw new LoginException(e.getMessage());
			
		}
		
		return data;
		
	}
	
	
	/***************************************************************
	 * New Client Biding form                                      *
	 * Overriden Method of ClientDao Interface                     *
	 **************************************************************/
	

	@Override
	public String clientBidingForm(TenderBids bid) {
		
		String message = "Please Enter valid data";
		
        try(Connection conn = DBUtility.provideConnection()){
        	
        	PreparedStatement cps = conn.prepareStatement("Select * from tender_bids where t_uid = ? AND client_uid = ?");
        	
			cps.setString(1, bid.getT_uid());
			cps.setString(2, bid.getClient_uid());
			
			ResultSet rs = cps.executeQuery();
			
			if(rs.next() == false) {
				
				PreparedStatement ps = conn.prepareStatement("insert into tender_bids(t_uid, client_uid, priceInCr)"
                        + "values (?,?,?)");


 
				ps.setString(1, bid.getT_uid());

				ps.setString(2, bid.getClient_uid());

				ps.setInt(3, bid.getPriceInCr());


				int x = ps.executeUpdate();


				if(x > 0) {


					message = "Your bid Placed wait for Admin to assigning bid";


				}
				
			
			}else {
				
				message = "May be You already placed bid on it or it is closed please check";
				
			}
			
			
        }
        catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	
	/***************************************************************
	 * New Client Biding history form                              *
	 * Overriden Method of ClientDao Interface                     *
	 **************************************************************/
	

	@Override
	public List<TenderBids> bidingHistory(String clientId) throws TenderException {
		
		List<TenderBids> bidList = new ArrayList<>();
		
		 try(Connection conn = DBUtility.provideConnection()){
	        	
	        	PreparedStatement cps = conn.prepareStatement("Select * from tender_bids where client_uid = ?");
	        	
				cps.setString(1, clientId);
				
				ResultSet rs = cps.executeQuery();
				
				while(rs.next()) {
					
					TenderBids bid = new TenderBids();
					
					bid.setClient_uid(rs.getString("client_uid"));
					bid.setT_uid(rs.getString("t_uid"));
					bid.setPriceInCr(rs.getInt("priceInCr"));
					
					bidList.add(bid);
					
				}
				
		 }	
				
				
	        catch (SQLException e) {
				
	        	throw new TenderException(e.getMessage());
	        	
			}
		
		
		return bidList;
	}

	
	/***************************************************************
	 * New Client Assigned or not form                             *
	 * Overriden Method of ClientDao Interface                     *
	 **************************************************************/
	

	@Override
	public List<TenderAdd> assignedTenderToClient(String clientId) throws TenderException {
		
		List<TenderAdd> assignedList = new ArrayList<>();
		
		try(Connection conn = DBUtility.provideConnection()){
        	
        	PreparedStatement cps = conn.prepareStatement("Select t_uid from assigned where client_uid = ?");
        	
			cps.setString(1, clientId);
			
			ResultSet rs = cps.executeQuery();
			
			boolean flag = true;
			
			while(rs.next()) {
				
				flag = false;
				
				PreparedStatement ps = conn.prepareStatement("Select * from assigned where t_uid = ?");
	        	
				ps.setString(1, rs.getString("t_uid"));
				
				ResultSet trs = ps.executeQuery();
				
				if(trs.next()) {
					
					TenderAdd t = new TenderAdd();
					
					t.setT_uid(trs.getString("t_uid"));
					t.setT_name(trs.getString("t_name"));
					t.setT_type(trs.getString("t_type"));
					
					assignedList.add(t);
					
				}
				
			}
			
			if(flag) {
				throw new TenderException("Please wait may be you are not assigned till yet...");
			}
			
	 }	
			
			
        catch (SQLException e) {
			
        	throw new TenderException(e.getMessage());
        	
		}
		
		return assignedList;
	}

}
