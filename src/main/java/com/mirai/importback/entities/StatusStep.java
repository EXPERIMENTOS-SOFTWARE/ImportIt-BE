package com.mirai.importback.entities;

import java.util.HashMap;
import java.util.Map;

public class StatusStep {
    Map<Integer, String> steps;

    public StatusStep() {
        this.steps = new HashMap<>();
        this.setSteps();
    }

    public void setSteps() {
        steps.put(1, "PENDING");
        steps.put(2, "ASSIGNED_TO_TRAVELER");
        steps.put(3, "TRAVELER_DEPARTED");
        steps.put(4, "TRAVELER_IN_TRANSIT");
        steps.put(5, "TRAVELER_ARRIVED");
        steps.put(6, "ORDER_DELIVERED");
    }

    public Map<Integer, String> getSteps() {
        return steps;
    }

    public void setSteps(Map<Integer, String> steps) {
        this.steps = steps;
    }
}
