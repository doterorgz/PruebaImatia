package com.imatia.pruebatecnica.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderTrackingListDTO implements Serializable {
    private List<OrderTrackingDTO> orderTrackings = new ArrayList<>();

    public OrderTrackingListDTO() {

    }

    public OrderTrackingListDTO(List<OrderTrackingDTO> orderTrackings) {
        this.orderTrackings = orderTrackings;
    }

    public List<OrderTrackingDTO> getOrderTrackings() {
        return orderTrackings;
    }

    public void setOrderTrackings(List<OrderTrackingDTO> orderTrackings) {
        this.orderTrackings = orderTrackings;
    }
}
