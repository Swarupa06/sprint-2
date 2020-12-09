package com.spring.ovs.exceptions;

public class VoterNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
public VoterNotFoundException(String message) {
	super(message);
}
}
