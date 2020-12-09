package com.spring.ovs.exceptions;

public class ElectionOfficerNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
   
	public ElectionOfficerNotFoundException(String message)
	{
		super(message);
	}

}

