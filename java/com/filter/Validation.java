package com.filter;

public class Validation {

	public static boolean isEmpty(String email)
	{
		
		boolean isError=false;
		if(email==null || email.trim().length()==0) {
			isError=true;
			
		}
		return isError;
		
	}

	public static boolean isEmailAlpha(String email)
	{
		boolean isError=false;
		if(email.matches("^(.+)@(\\S+)$")==false)
		{
			isError=true;
		}
		return isError;
	}
	
	public static boolean isPasswordAlpha(String password)
	{
		boolean isError=false;
		if(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#*$%^&+=])(?=\\S+$).{8,}$")==false)
		{
			isError = true;
		}
		return isError;
		}
	
	public static boolean chackLength(String firstname) {
		boolean isError = false;
		if(firstname.trim().length()<2) {
			return true;
			
		}
		return isError;
	}
	
	public static boolean isNameAlpha(String hrname) {
		boolean isError = false;
		if(hrname.matches("[a-zA-Z]+")==false) {
			isError=true;
		}
		return isError;
	}
	
	public static boolean isMobNuAlpha(String hrmobno) {
		boolean isError = false;
		if(hrmobno.matches("[0-9]+")==false) {
			isError=true;
		}
		return isError;
	}
	
	}
	

