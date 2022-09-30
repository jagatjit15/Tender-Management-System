package com.tm.usecases;

import java.util.List;
import java.util.Scanner;

import com.tm.beans.TenderBids;
import com.tm.dao.ClientDaoImple;
import com.tm.dao.ClientsDao;
import com.tm.exceptions.TenderException;

public class ClientBidingHistoryUsecases {
	
	public static void displayHistory() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("><><><><> You Biding History <><><><><");
		System.out.println();
		
		System.out.println("Enter you userId / UniqueId");
		String id = sc.next();
		
		System.out.println();
		
		ClientsDao dao = new ClientDaoImple();
		
		try {
			
			List<TenderBids> history = dao.bidingHistory(id);
			
			if(history.isEmpty()) {
				
				System.out.println("You don't have any biding history");
				
			}else {
				
				System.out.println("You have total "+history.size()+" biding History");
				
				history.forEach(bid ->{
					System.out.println();
					System.out.println("Your client_Id : "+bid.getClient_uid());
					System.out.println("Your Tender_Id : "+bid.getT_uid());
					System.out.println("Your Bid price : "+bid.getPriceInCr());
					System.out.println();
					
				});
				
				
			}
			
			
		} catch (TenderException e) {

			System.out.println(e.getMessage());
			
			System.out.println();
			
		}
		
		
		
	}

}
