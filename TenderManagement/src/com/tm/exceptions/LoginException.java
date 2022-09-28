package com.tm.exceptions;


public class LoginException extends Exception {
	
//	This class for getting any kind of login exception
	
	public LoginException() {
		
//		This method will through an exception if exception occurs 
		
	}
	
	public LoginException(String message) {
		
		super(message);
		
	}

}
