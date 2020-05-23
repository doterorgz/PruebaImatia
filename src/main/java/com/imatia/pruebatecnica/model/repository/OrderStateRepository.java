package com.imatia.pruebatecnica.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imatia.pruebatecnica.model.entity.OrderState;

@Repository
public interface OrderStateRepository extends JpaRepository<OrderState, Long> {

}
