package com.imatia.pruebatecnica.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderState")
public class OrderState {
	@Id @GeneratedValue
	private Long id;
	private Long orderId;
	private int stateId;
	private Date stateUpdateDate;
	
	public OrderState() {
		super();
	}
	public OrderState(Long orderId, int stateId, Date orderUpdateDate) {
		super();
		this.orderId = orderId;
		this.stateId = stateId;
		this.stateUpdateDate = orderUpdateDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public Date getStateUpdateDate() {
		return stateUpdateDate;
	}
	public void setStateUpdateDate(Date orderUpdateDate) {
		this.stateUpdateDate = orderUpdateDate;
	}
	
	@Override
	public String toString() {
		return "OrderState [orderId=" + orderId + ", orderState=" + stateId + ", orderUpdateDate=" + stateUpdateDate
				+ "]";
	}	
}
