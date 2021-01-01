package com.vmware.vmscheduler.vmschedulerspringboot.exception;

import java.sql.Timestamp;

public class VMSErrorResponse {
	private int status;
	private String message;
	private Timestamp timeStamp;
	
	public VMSErrorResponse() {
		
	}

	public VMSErrorResponse(int status, String message, Timestamp timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
}
