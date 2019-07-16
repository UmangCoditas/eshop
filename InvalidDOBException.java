package com.practice.tavisca.eshop;

public class InvalidDOBException extends RuntimeException {
	
	private String message;
	
	 public InvalidDOBException(String message) {
	        this.message = message;
	    }
	   
	    @Override
	    public String getMessage(){
	        return message;
	    } 

}
