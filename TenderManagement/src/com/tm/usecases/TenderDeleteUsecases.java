package com.tm.usecases;

import java.util.Scanner;

import com.tm.beans.TenderAdd;
import com.tm.dao.AdminDao;
import com.tm.dao.AdminDaoImple;
import com.tm.exceptions.TenderException;

public class TenderDeleteUsecases {
	
	public static void deleteATender() {
		

		Scanner sc = new Scanner(System.in);
		
		System.out.println("*********************************");
		
		System.out.println("Enter your Tender UniqueId you want to delete");
		
		System.out.println("*********************************");
		
		System.out.println();
		
		System.out.println("Enter your tender uniqueId");
		String uid = sc.next();
		
		AdminDao dao = new AdminDaoImple();
		
		try {
			
		  TenderAdd res = dao.deleteTender(uid);
		  
		  System.out.println();
		  System.out.println("Tender with Id"+res.getT_uid()+"Deleted successfully...");
		  System.out.println();
			
		} catch (TenderException e) {

			System.out.println(e.getMessage());
			
		}
		
	}

}
