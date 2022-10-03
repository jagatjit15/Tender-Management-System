package com.tm.usecases;

import java.util.Scanner;

import com.tm.dao.AdminDao;
import com.tm.dao.AdminDaoImple;

public class TenderAssigningUsecases {
	
public static void tenderAssigning() {
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("*********************************");
	
	System.out.println("Enter uniqueId of tender and Vender / Clients to Assign");
	
	System.out.println("*********************************");
	
	System.out.println();
	
	System.out.println("Enter your tender Uid / UniqueId");
	String t_Uid = sc.next();
	
	System.out.println("Enter your Client Uid / UniqueId");
	String c_uid = sc.next();
	
	System.out.println("Enter Assign date (ex: 2022-09-29)");
	String date = sc.next();
	
	System.out.println();
	sc.close();

	
	AdminDao dao = new AdminDaoImple();
	
	String message = dao.assignTenderToVendor(t_Uid, c_uid, date);
	
	System.out.println(message);
	
	System.out.println();
}

}
