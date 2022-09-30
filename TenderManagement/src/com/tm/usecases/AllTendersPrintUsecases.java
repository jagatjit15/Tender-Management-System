package com.tm.usecases;

import java.util.List;

import com.tm.beans.TenderAdd;
import com.tm.dao.AdminDao;
import com.tm.dao.AdminDaoImple;
import com.tm.exceptions.TenderException;

public class AllTendersPrintUsecases {
	
	
	public static void displayAlltenders() {
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("Availabe Tenders");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println();
		
		AdminDao dao = new AdminDaoImple();
		
		try {
			
			List<TenderAdd> tendersList = dao.printAllTenders();
			

			if(tendersList.isEmpty()) {
				System.out.println("Data not found.....");
			}
			else {
				
				
				tendersList.forEach(tender -> {
					
					System.out.println();
					
					System.out.println("Tender UniqueId -> "+tender.getT_uid());
					System.out.println(" Tender Name -> "+tender.getT_name());
					System.out.println(" Tender Status -> "+tender.getStatus());
					System.out.println(" Tender Duration -> "+tender.getT_duration());
					System.out.println(" Tender Release Date -> "+tender.getStart_date());
					System.out.println(" Tender End Date -> "+tender.getEnd_date());
					System.out.println(" Tender type -> "+tender.getT_type());
					
					
				});
				System.out.println();
				System.out.println("************************************************************************");
				System.out.println();
			}
			
			
			
			
		} catch (TenderException e) {
			
			System.out.println(e.getMessage());
			System.out.println();
			
		}
		
	}
	
	

}
