package com.reactcurd.exception;

public class ResourceNotFoundException  extends RuntimeException{
	
	public ResourceNotFoundException (String message) {
	
		super(message);
		System.out.println("inside the ResoureceNot found exception" );
	}

}
