package com.imatia.pruebatecnica.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="StateMachine")
public class StateMachine {
    @Id @GeneratedValue
    private int id;

    private int initialStateId;
    private int finalStateId;

    @OneToMany(mappedBy = "stateMachineId")
    private List<Transition> transitions;

    public StateMachine() {
    }

    public StateMachine(int initialStateId, int finalStateId, List<Transition> transitions) {
        this.finalStateId = finalStateId;
        this.initialStateId = initialStateId;
        this.transitions = transitions;
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

    public List<Transition> getTransition() {
        return transitions;
    }

    public void setTransition(List<Transition> transitions) {
        this.transitions = transitions;
    }
}
