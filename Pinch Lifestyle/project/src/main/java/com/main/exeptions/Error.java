package com.main.exeptions;

@SuppressWarnings("serial")
public class Error extends RuntimeException{

	String msg;
	public Error(String s) {
		msg = s;
	}
	
	@Override
	public String toString() {
		return "Custom Exeption Occured : " + msg;
	}
	
	public Error() {
		System.out.println("An unexpected error occur.");
	}
}
