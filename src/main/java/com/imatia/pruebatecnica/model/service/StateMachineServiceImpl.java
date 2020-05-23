package com.imatia.pruebatecnica.model.service;

import org.springframework.stereotype.Service;

@Service
public class StateMachineServiceImpl implements StateMachineService {

    public boolean isValidTransition(int currentStateId, int nextStateId) {
        if (currentStateId ==4
            || nextStateId == 1
            || currentStateId == nextStateId) return false;
        else return true;
    }
}
