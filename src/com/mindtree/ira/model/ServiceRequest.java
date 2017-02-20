package com.mindtree.ira.model;

import java.io.Serializable;

public class ServiceRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String requestId;
	private String roomNo;
	private String requestDesc;
	private String status;
	
	public ServiceRequest(String requestId, String roomNo, String requestDesc, String status) {
		super();
		this.requestId = requestId;
		this.roomNo = roomNo;
		this.requestDesc = requestDesc;
		this.status = status;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRequestDesc() {
		return requestDesc;
	}
	public void setRequestDesc(String requestDesc) {
		this.requestDesc = requestDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
