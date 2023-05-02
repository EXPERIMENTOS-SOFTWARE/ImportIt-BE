package com.mirai.importback.services.impl;

import com.mirai.importback.entities.Orders;
import com.mirai.importback.entities.StatusStep;

public class UpdateOrderStepsService {

    private Orders order;
    private StatusStep step;

    public UpdateOrderStepsService(Orders order) {
        this.order = order;
        this.step = new StatusStep();
    }

    public void updateOrderStatus() {
        int currentStatus = order.getStatusStep();
        order.setStatus(step.getSteps().get(currentStatus + 1));
        order.setStatusStep(currentStatus + 1);
    }

    public String getStatusMessage() {
        return this.order.getStatus();
    }
}
