package unitTests;

import com.mirai.importback.entities.Orders;
import com.mirai.importback.entities.StatusStep;
import com.mirai.importback.services.impl.UpdateOrderStepsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UpdateOrderStepsServiceTest {

    UpdateOrderStepsService sendOrderUpdateService;
    Orders order;
    StatusStep steps;

    UpdateOrderStepsServiceTest() {
        this.order = new Orders("", 0);
        this.sendOrderUpdateService = new UpdateOrderStepsService(this.order);
        this.steps = new StatusStep();
    }

    @Test
    void testOrderIsPending() {
        this.sendOrderUpdateService.updateOrderStatus();
        Assertions.assertEquals("PENDING", this.sendOrderUpdateService.getStatusMessage());
    }

    @Test
    void testOrderStepsFlow() {
        for (int i = 1; i <= 5; i++) {
            this.sendOrderUpdateService.updateOrderStatus();
            Assertions.assertEquals(this.steps.getSteps().get(i), this.sendOrderUpdateService.getStatusMessage());
        }
    }
}
