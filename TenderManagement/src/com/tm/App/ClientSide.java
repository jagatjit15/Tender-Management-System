package com.tm.App;

import java.util.Scanner;


import com.tm.beans.ClientsData;
import com.tm.dao.ClientDaoImple;
import com.tm.dao.ClientsDao;
import com.tm.exceptions.LoginException;
import com.tm.usecases.AllTendersPrintUsecases;
import com.tm.usecases.BidingFormUsecases;
import com.tm.usecases.ClientAssignedBidUsecases;
import com.tm.usecases.ClientBidingHistoryUsecases;
import com.tm.usecases.PrintAllBidsUsecases;

public class ClientSide {
	
	 
        public static void clientOperations() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("><><><><> Menu <><><><><");
		System.out.println();
		
		System.out.println("1. All Tenders");
		System.out.println("2. Make A bid");
		System.out.println("3. Bid History");
		System.out.println("4. All bids");
		System.out.println("5. Assigned Bid");
		System.out.println("6. Exit App");
		
		System.out.println();
		
		System.out.println("Enter your button ( like 1 or 2...)");
		int choice = sc.nextInt();
		
		switch(choice) {
			
		case 1: AllTendersPrintUsecases.displayAlltenders();

		clientOperations(); 

			break;
			
		case 2:BidingFormUsecases.clientBiding();
			
		clientOperations(); 
		
			break;
			
			
		case 3:ClientBidingHistoryUsecases.displayHistory();
		
		clientOperations();
			
			break;
			
			
		case 4: PrintAllBidsUsecases.displayBids();

		clientOperations(); 

			break;	
			
		case 5:ClientAssignedBidUsecases.displayStatusofBiding();
		
		clientOperations(); 

			break;	
			
			
		case 6: App.main(null);
			break;	
			
			
		default : System.out.println("Choose a right option");
			
		clientOperations();
		   break;
		}
		
		
	}
	
	
	public static void clientpanel() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		
		System.out.println("********> VENDER LOGIN <********");
		
		System.out.println();
		
		System.out.println("=================================");
		
		System.out.println("Enter you Userid");
		String userid = sc.next();
		
		System.out.println("Enter your password");
		String passcode = sc.next();
		
		ClientsDao dao = new ClientDaoImple();
		
		try {
			
			
			ClientsData clientData = dao.clientLoginForm(userid, passcode);
			
			System.out.println();
			
			System.out.println("********** --> Welcome "+ clientData.getClient_name() +" <-- **********");
			
			System.out.println();
			
			System.out.println();
			
			clientOperations();
			
			
		} catch (LoginException e) {

			System.out.println(e.getMessage());
			
			System.out.println();
			
			
			ClientSide.clientpanel();
			
			
		}
		
	}
	

}
