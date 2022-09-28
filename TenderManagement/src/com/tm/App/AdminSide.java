package com.tm.App;

import java.util.Scanner;

import com.tm.beans.AdminData;
import com.tm.dao.AdminDao;
import com.tm.dao.AdminDaoImple;
import com.tm.exceptions.LoginException;

public class AdminSide {
	
	
//	Admin operation method for different types of operation allowed to Admin
	
	public static void adminOperations() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("@@@@-> Menu <-@@@@");
		
		System.out.println("1. Add a tender");
		System.out.println("2. Assign a tender");
		System.out.println("3. Delete a tender");
		System.out.println("4. Update a tender");
		System.out.println("5. All tenders");
		System.out.println("6. Tender with condition");
		System.out.println("7. Exit App");
		
		System.out.println();
		
		System.out.println("Enter your button ( like 1 or 2...)");
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:
			break;
			
		case 2:
			break;	
		
			
		case 3:
			break;
			
			
		case 4:
			break;
			
		case 5:
			break;	
			
			
		case 6:
			break;	
			
			
		case 7:
			break;	
			
			
		default : adminOperations();
		   break;
		}
		
		
	}
	
	
	
	
	
//	Admin login pannel or Login form method
	public static void adminpanel() {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		
		System.out.println("********> ADMIN LOGIN <********");
		
		System.out.println();
		
		System.out.println("=================================");
		
		System.out.println("Enter you Userid");
		String userid = sc.next();
		
		System.out.println("Enter your password");
		String passcode = sc.next();
		
		AdminDao dao = new AdminDaoImple();
		
		try {
			
			
			AdminData admindata = dao.adminLoginForm(userid, passcode);
			
			System.out.println();
			
			System.out.println("********** --> Welcome "+admindata.getName()+" <-- **********");
			
			System.out.println();
			
			System.out.println("....***....***....***....***....***....***.....***....");
			
			adminOperations();
			
			
		} catch (LoginException e) {

			System.out.println(e.getMessage());
			
			System.out.println();
			
			System.out.println("Please Enter Valid User_id and Password");
			
			AdminSide.adminpanel();
			
			
		}
		
	}

}
