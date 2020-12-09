package com.spring.ovs.exceptions;


public class SocietyNotFoundException extends RuntimeException
{
	
	
	private static final long serialVersionUID = 1L;
	
	public SocietyNotFoundException()
	{
		
	}

	public SocietyNotFoundException(String message)
	{
		super(message);
	}
    
	public SocietyNotFoundException(String message,Throwable clause) 
	{
		super(message,clause);
	}
	
	public SocietyNotFoundException(Throwable clause)
	{
		super(clause);
	}
	
}




