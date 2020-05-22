package com.imatia.pruebatecnica.model.repository;

import com.imatia.pruebatecnica.model.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
