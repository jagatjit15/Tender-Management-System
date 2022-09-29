package com.tm.usecases;

import java.util.List;

import com.tm.beans.ClientsData;
import com.tm.dao.AdminDao;
import com.tm.dao.AdminDaoImple;
import com.tm.exceptions.TenderException;

public class PrintClientsDataUsecases {
	
	public static void displyaClients() {
		
		System.out.println();
		
		System.out.println("~~~~~~~~ All Clients ~~~~~~~~~");
		
		System.out.println();
		
		AdminDao dao = new AdminDaoImple();
		
		try {
			
			List<ClientsData> clientsList = dao.printAllClients();
			
			if(clientsList.isEmpty()) {
				
				System.out.println("No data found...");
				System.out.println();
			}
			else {
				
				clientsList.forEach(client -> {
					
					System.out.println("Client Name : "+client.getClient_name());
					
					System.out.println("Client UniqueId : "+client.getClient_uid());
					
					System.out.println("Client Email : "+client.getClient_mobile());
					
					System.out.println("Client Password : "+client.getClient_password());
					
					System.out.println("Client Nationality : "+client.getCountry());
					
					
				});
				
				System.out.println();
				
			}
			
		} catch (TenderException e) {
			
			System.out.println(e.getMessage());
			System.out.println();
			
		}
		
	}

}
