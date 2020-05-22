package com.imatia.pruebatecnica.model.dto;

import java.util.Date;

public class OrderTrackingDTO {
	private Long orderId;
	private short trackingStatusId;
	private Date changeStatusDate;
	
	
	public OrderTrackingDTO() {
		super();
	}
	public OrderTrackingDTO(Long orderId, short trackingStatusId, Date changeStatusDate) {
		super();
		this.orderId = orderId;
		this.trackingStatusId = trackingStatusId;
		this.changeStatusDate = changeStatusDate;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public short getTrackingStatusId() {
		return trackingStatusId;
	}
	public void setTrackingStatusId(short trackingStatusId) {
		this.trackingStatusId = trackingStatusId;
	}
	public Date getChangeStatusDate() {
		return changeStatusDate;
	}
	public void setChangeStatusDate(Date changeStatusDate) {
		this.changeStatusDate = changeStatusDate;
	}
	@Override
	public String toString() {
		return "OrderTrackingDTO [orderId=" + orderId + ", trackingStatusId=" + trackingStatusId + ", changeStatusDate="
				+ changeStatusDate + "]";
	}
	
	
}
