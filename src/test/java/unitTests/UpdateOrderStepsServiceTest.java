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
        this.order = new Orders("PENDING", 1);
        this.sendOrderUpdateService = new UpdateOrderStepsService();
        this.steps = new StatusStep();
    }

    @Test
    void testOrderIsPending() {
        Assertions.assertEquals("PENDING", this.sendOrderUpdateService.getStatusMessage(this.order));
    }

    @Test
    void testManualOrderStatusUpdate() {
        this.sendOrderUpdateService.updateOrderStatus(this.order, 4);
        Assertions.assertEquals("TRAVELER_IN_TRANSIT", this.sendOrderUpdateService.getStatusMessage(this.order));
    }

    @Test
    void testOrderStepsFlow() {
        for (int i = 2; i <= 5; i++) {
            this.sendOrderUpdateService.updateOrderStatus(this.order);
            Assertions.assertEquals(this.steps.getSteps().get(i), this.sendOrderUpdateService.getStatusMessage(this.order));
        }
    }
}
