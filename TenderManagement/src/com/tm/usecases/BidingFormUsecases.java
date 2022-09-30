package com.tm.usecases;

import java.util.Scanner;

import com.tm.beans.TenderBids;
import com.tm.dao.ClientDaoImple;
import com.tm.dao.ClientsDao;

public class BidingFormUsecases {
	
	public static void clientBiding() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		
		System.out.println("<><><>< Welcome To Biding ><><><>");
		
		System.out.println();
		
		System.out.println("Enter your UniqueId/UserID");
		String userId = sc.next();
		
		System.out.println("Enter UniqueId of Tender You want to bod for");
		String tenderId = sc.next();
		
		System.out.println("Enter amount you want to Bid (between 10 - 10000");
		int price = sc.nextInt();
		
		TenderBids bid = new TenderBids();
		
		bid.setT_uid(tenderId);
		bid.setClient_uid(userId);
		bid.setPriceInCr(price);
		
		ClientsDao dao = new ClientDaoImple();
		
		String msg = dao.clientBidingForm(bid);
		
		System.out.println();
		System.out.println(msg);
		System.out.println();
		
		
		
	}

}
