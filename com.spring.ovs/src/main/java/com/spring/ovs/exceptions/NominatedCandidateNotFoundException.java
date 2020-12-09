package com.spring.ovs.exceptions;

public class NominatedCandidateNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public NominatedCandidateNotFoundException(String message)
	{
		super(message);
	}

}
