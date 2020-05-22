package com.imatia.pruebatecnica.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transition")
public class Transition {
    @Id
    @GeneratedValue
    private int id;

    private int initialStateId;
    private int finalStateId;

    private int stateMachineId;

    public Transition() {
    }
    public Transition(int initialStateId, int finalStateId, int stateMachineId) {
        this.initialStateId = initialStateId;
        this.finalStateId = finalStateId;
        this.stateMachineId = stateMachineId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInitialStateId() {
        return initialStateId;
    }

    public void setInitialStateId(int initialStateId) {
        this.initialStateId = initialStateId;
    }

    public int getFinalStateId() {
        return finalStateId;
    }

    public void setFinalStateId(int finalStateId) {
        this.finalStateId = finalStateId;
    }

    public int getStateMachineId() {
        return stateMachineId;
    }

    public void setStateMachineId(int stateMachineId) {
        this.stateMachineId = stateMachineId;
    }
}
