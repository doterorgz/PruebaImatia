package com.imatia.pruebatecnica.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imatia.pruebatecnica.model.entity.OrderState;

@Repository
public interface OrderStateRepository extends CrudRepository<OrderState, Long> {

}
