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

public class AdminDaoImple implements AdminDao{

	
//	Override method of AdminDao for admin registration.
	
	@Override
	public String newAdminRegistertoDB(AdminData admindata) {
		
		String message = "Try again....";
		
		
		try(Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into admin(admin_uid,name, email, mobile,"
					                                         + "password, organization, country, state)"
					                                         + "values (?,?,?,?,?,?,?,?)");
			
			ps.setString(1, admindata.getAdmin_uid());
			ps.setString(2, admindata.getName());
			ps.setString(3, admindata.getEmail());
			ps.setString(4, admindata.getMobile());
			ps.setString(5, admindata.getPassword());
			ps.setString(6, admindata.getOrganization());
			ps.setString(7, admindata.getCountry());
			ps.setString(8, admindata.getState());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				
				message = "Registered Successfully....."+"UserName : "+admindata.getAdmin_uid()+" | Password : "+admindata.getPassword();
				
			}
			
		
		} catch (SQLException e) {
			
			message = e.getMessage();
			
		}
		
		
		return message;
		
	}
	
	
	
//*********************************************************************************
	
//	Override method of AdminDao for Login of Admin
	
//*********************************************************************************	
	@Override
	public AdminData adminLoginForm(String username, String password) throws LoginException {
		
		AdminData admindata = new AdminData();
		
		
		try(Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from admin where admin_uid = ? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				admindata.setName(rs.getString("name"));
				
			}
			else {
				throw new LoginException("Invalid user_Id or password....");
			}
			
			
			
		} catch (SQLException e) {

			throw new LoginException(e.getMessage());
			
		}
		
		return admindata;
	}

	/*
	 ***********************************************************
	 *for adding tenders into the tender section and
	 * this is the overriden method of AdminDao
	 * *********************************************************
	*/


	@Override
	public TenderAdd tenderAddtoApp(TenderAdd addtender) throws TenderException {
		
		TenderAdd res = new TenderAdd();
		
		try(Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into tenders(t_uid, t_name,"
					                                    + " t_type,t_duration, start_date, end_date, status) "
					                                    + "values (?,?,?,?,?,?,?)");
			
			ps.setString(1, addtender.getT_uid());
			ps.setString(2, addtender.getT_name());
			ps.setString(3, addtender.getT_type());
			ps.setString(4, addtender.getT_duration());
			ps.setString(5, addtender.getStart_date());
			ps.setString(6, addtender.getEnd_date());
			ps.setString(7, addtender.getStatus());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				res.setT_uid(addtender.getT_uid());
			}
			else {
				throw new TenderException("Sorry Try again....");
			}
			
			
		} catch (SQLException e) {

			throw new TenderException(e.getMessage());
			
		}
		
		return res;
	}


	/*
	 ***********************************************************
	 *for Assignning a tender to a vender or bider
	 * this is the overriden method of AdminDao
	 * *********************************************************
	*/
	

	@Override
	public String assignTenderToVendor(String tenderId, String clientId, String date) {
		 
		String message = "Please check ids..";
		
		try(Connection conn = DBUtility.provideConnection();){
			
            PreparedStatement bidps = conn.prepareStatement("select * from tender_bids where client_uid = ?");
            
            bidps.setString(1, clientId);
			
			ResultSet bidRs = bidps.executeQuery();
			
			if(bidRs.next()) {
				
				PreparedStatement tps = conn.prepareStatement("select * from tenders where t_uid = ?");
				
				tps.setString(1, tenderId);
				
				ResultSet tenderRs = tps.executeQuery();
				
	            PreparedStatement vps = conn.prepareStatement("select * from clients where client_uid = ?");
	            
	            vps.setString(1, clientId);
				
				ResultSet clientRs = vps.executeQuery();
				
//				data extracting from clients table
				String Cuid = clientRs.getString("client_uid");
				String Ccountry = clientRs.getString("country");
				
				
//				Data extarcting from tenders Table
				String Tuid = tenderRs.getString("t_uid");
				
				
//				Data extracting from tender_bids table
				String price = bidRs.getString("priceInCr");
				
				
				PreparedStatement ps = conn.prepareStatement("insert into assigned(t_uid, client_uid, client_country,"
						                                    + " t_price, assign_date values (?,?,?,?,?)");
				
				ps.setString(1, Tuid);
				ps.setString(2, Cuid);
				ps.setString(3, Ccountry);
				ps.setString(4, price);
				ps.setString(5, date);
				
				int x = ps.executeUpdate();
				
				if(x > 0) {
					message = "Tender assigned to Bider successfully....";
				}else {
					message = "Please provide right credentials...";
				}
			}else {
				
				message = "No bids found with clientId "+clientId;
				
			}
			
			
			
		} catch (SQLException e) {
			
			message = e.getMessage();
			
		}
		
		return message;
	}

	/*
	 ***********************************************************
	 *for Deleting a tender
	 * this is the overriden method of AdminDao
	 * *********************************************************
	*/

	@Override
	public TenderAdd deleteTender(String tenderId) throws TenderException {
		
		TenderAdd deleted = new TenderAdd();
		
		try (Connection conn = DBUtility.provideConnection();){
			
			PreparedStatement ps = conn.prepareStatement("delete from tenders where t_uid = ?");
			
			ps.setString(1, tenderId);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				deleted.setT_uid(tenderId);
			}
			else {
				throw new TenderException("No data found with id "+tenderId);
			}
			
		} catch (SQLException e) {

			throw new TenderException(e.getMessage());

		}
		
		return deleted;
	}


	/*
	 ***********************************************************
	 *for Viewing all tender details
	 * this is the overriden method of AdminDao
	 * *********************************************************
	*/
	

	@Override
	public List<TenderAdd> printAllTenders() throws TenderException {
		
		List<TenderAdd> tendersList = new ArrayList<>();
		
		try(Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from tenders order by status desc");
			
			ResultSet rs = ps.executeQuery();
			
            boolean flag = false;
			
			while(rs.next()) {
				
				flag = true;
				
				String UniqueId = rs.getString("t_uid");
				String name = rs.getString("t_name");
				String type = rs.getString("t_type");
				String duration = rs.getString("t_duration");
				String release_date = rs.getString("start_date");
				String end_date = rs.getString("end_date");
				String status = rs.getString("status");
				
				TenderAdd tender = new TenderAdd();
				
				tender.setT_uid(UniqueId);
				tender.setT_name(name);
				tender.setT_type(type);
				tender.setT_duration(duration);
				tender.setStart_date(release_date);
				tender.setEnd_date(end_date);
				tender.setStatus(status);
				
				tendersList.add(tender);
				
			}
			
			if(!flag) {
				throw new TenderException("No data found...");
			}
			
		} catch (SQLException e) {
			
			throw new TenderException(e.getMessage());
			
		}
		
		
		
		return tendersList;
	}


	
	/*
	 ***********************************************************
	 *for Viewing all bids details
	 * this is the overriden method of AdminDao
	 * *********************************************************
	*/
	

	@Override
	public List<TenderBids> printAllBids() throws TenderException {
		
		
        List<TenderBids> allBidList = new ArrayList<>();
		
		try(Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from tender_bids order by priceInCr ");
			
			ResultSet rs = ps.executeQuery();
			
            boolean flag = false;
			
			while(rs.next()) {
				
				flag = true;
				
				String UniqueId = rs.getString("t_uid");
				String ClientId = rs.getString("client_uid");
				int price = rs.getInt("priceInCr");
				
				TenderBids bids = new TenderBids();
				
				bids.setT_uid(UniqueId);
				bids.setClient_uid(ClientId);
				bids.setPriceInCr(price);
				
				allBidList.add(bids);
				
			}
			
			if(!flag) {
				throw new TenderException("No data found...");
			}
			
		} catch (SQLException e) {
			
			throw new TenderException(e.getMessage());
			
		}
		
		
		
		return allBidList;
		
	}


	/*
	 ***********************************************************
	 *for Viewing all Clients Information details
	 * this is the overriden method of AdminDao
	 * *********************************************************
	*/

	@Override
	public List<ClientsData> printAllClients() throws TenderException {
	

        List<ClientsData> clientList = new ArrayList<>();
		
		try(Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from clients order by client_name");
			
			ResultSet rs = ps.executeQuery();
			
            boolean flag = false;
			
			while(rs.next()) {
				
				flag = true;
				
				String UniqueId = rs.getString("client_uid");
				String name = rs.getString("client_name");
				String email = rs.getString("client_email");
				String mobile = rs.getString("client_mobile");
				String country = rs.getString("country");
				
				ClientsData client = new ClientsData();
				
				client.setClient_uid(UniqueId);
				client.setClient_name(name);
				client.setClient_email(email);
				client.setClient_mobile(mobile);
				client.setCountry(country);
				client.setClient_password("********");
				
				clientList.add(client);
				
			}
			
			if(!flag) {
				throw new TenderException("No data found...");
			}
			
		} catch (SQLException e) {
			
			throw new TenderException(e.getMessage());
			
		}
		
		
		
		return clientList;
		
	}

}
