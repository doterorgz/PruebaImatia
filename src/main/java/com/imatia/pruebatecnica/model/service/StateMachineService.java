package com.imatia.pruebatecnica.model.service;

public interface StateMachineService {
    boolean isValidTransition(int currentStateId, int nextStateId);
}
