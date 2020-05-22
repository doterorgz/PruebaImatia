package com.imatia.pruebatecnica.model.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Order")
public class Order {
	@Id
	@GeneratedValue
	private Long id;

	@OneToMany( mappedBy = "orderId")
	private List<OrderState> states;
	private int currentStateId;

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderState> getStates() {
		return states;
	}

	public void setStates(List<OrderState> states) {
		this.states = states;
	}

	public int getCurrentStateId() {
		return currentStateId;
	}

	public void setCurrentStateId(int currentStateId) {
		this.currentStateId = currentStateId;
	}
}
