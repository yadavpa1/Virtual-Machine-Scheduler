package com.vmware.vmscheduler.vmschedulerspringboot.exception;

public class RecordNotFoundException extends RuntimeException{

	public RecordNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecordNotFoundException(String message) {
		super(message);
	}

	public RecordNotFoundException(Throwable cause) {
		super(cause);
	}
	

}
