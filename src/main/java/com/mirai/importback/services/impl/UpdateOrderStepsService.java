package com.mirai.importback.services.impl;

import com.mirai.importback.entities.Orders;
import com.mirai.importback.entities.StatusStep;

public class UpdateOrderStepsService {

    private StatusStep step;

    public UpdateOrderStepsService() {
        this.step = new StatusStep();
    }

    public void updateOrderStatus(Orders order) {
        int currentStatus = order.getStatusStep();
        order.setStatus(step.getSteps().get(currentStatus + 1));
        order.setStatusStep(currentStatus + 1);
    }

    public String getStatusMessage(Orders order) {
        return order.getStatus();
    }
}
