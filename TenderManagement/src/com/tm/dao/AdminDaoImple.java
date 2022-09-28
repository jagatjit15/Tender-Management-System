package com.tm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tm.beans.AdminData;
import com.tm.exceptions.LoginException;
import com.tm.utility.DBUtility;

public class AdminDaoImple implements AdminDao{

	
//	Override method of AdminDao for admin registration.
	
	@Override
	public String newAdminRegistertoDB(AdminData admindata) {
		
		String message = "Something went wrong....try later...";
		
		
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
			
			e.printStackTrace();
			
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

}
