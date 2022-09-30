package com.tm.usecases;

import java.util.List;

import com.tm.beans.TenderBids;
import com.tm.dao.AdminDao;
import com.tm.dao.AdminDaoImple;
import com.tm.exceptions.TenderException;

public class PrintAllBidsUsecases {
	
	public static void displayBids() {
		
		System.out.println();
		System.out.println(">>>>>>>> All Bids <<<<<<<<");
		System.out.println();
		
		AdminDao dao = new AdminDaoImple();
		
		try {
			
			List<TenderBids> bidLists = dao.printAllBids();
			
			if(bidLists.isEmpty()) {
				System.out.println("Data not found.....");
			}
			else {
				
				bidLists.forEach(bids ->{
					System.out.println();
					
					System.out.println(" Tender UniqueId :-> "+bids.getT_uid());
					System.out.println(" Client UniqueId :-> "+bids.getClient_uid());
					System.out.println(" Client bidPrice in Cr:-> "+bids.getPriceInCr());
					
					System.out.println();
				});
				
			}
			
		} catch (TenderException e) {

			System.out.println(e.getMessage());
			System.out.println();
			
		}
		
	}

}
