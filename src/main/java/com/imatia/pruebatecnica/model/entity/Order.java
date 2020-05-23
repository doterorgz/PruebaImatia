package com.imatia.pruebatecnica.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Order")
public class Order {
	@Id
	private Long id;

	@OneToMany( mappedBy = "orderId")
	private List<OrderState> states;

	public Order() {
		this.states = new ArrayList<OrderState>();
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
}
