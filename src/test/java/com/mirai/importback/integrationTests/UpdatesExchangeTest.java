package com.mirai.importback.integrationTests;

import com.mirai.importback.entities.Message;
import com.mirai.importback.entities.Orders;
import com.mirai.importback.entities.Users;
import com.mirai.importback.services.impl.MessagingService;
import com.mirai.importback.services.impl.UpdateOrderStepsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDateTime;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UpdatesExchangeTest {
    private MessagingService messagingService;
    private UpdateOrderStepsService updateOrderStepsService;
    private Orders order;
    private Users traveler;
    private Users user;
    private ArrayList<Message> messages;

    public UpdatesExchangeTest() {
        this.order = new Orders("", 0);
        this.messagingService = new MessagingService();
        this.updateOrderStepsService = new UpdateOrderStepsService();
        this.traveler = new Users();
        this.user = new Users();
        this.messages = new ArrayList<>();
    }

    @BeforeAll
    void setup() {
        this.user.setName("Jeno Jibarez");
        this.traveler.setName("Karina Alcidez");
        this.messages.add(new Message(this.traveler.getName(), LocalDateTime.now(),"Hey! This is Karina, I've just been assigned to your order!"));
        this.messages.add(new Message(this.user.getName(), LocalDateTime.now(),"Hi, thanks! Please, keep me informed about the status of my order."));
        this.messages.add(new Message(this.traveler.getName(), LocalDateTime.now(),"No problem! I'm on my way, just boarded the plane!"));
        this.messages.add(new Message(this.user.getName(), LocalDateTime.now(),"Is my order still intact?"));
        this.messages.add(new Message(this.traveler.getName(), LocalDateTime.now(),"Safe and sound! Here's a photo of your order. Nice and new!"));
        this.messages.add(new Message(this.user.getName(), LocalDateTime.now(),"Great, thanks! 😄"));
        this.messages.add(new Message(this.traveler.getName(), LocalDateTime.now(),"Just arriver and left it at your porch"));
        this.messages.add(new Message(this.user.getName(), LocalDateTime.now(),"You are the best, thanks!"));
    }

    @Test
    void testOrderIsOpenedAndClosed() {
        // assign order to a traveler
        this.order.setTravelerAssigned(true);
        // update order Status to TRAVELER_ASSIGNED
        updateOrderStepsService.updateOrderStatus(this.order, 2);

        Assertions.assertEquals("ASSIGNED_TO_TRAVELER", this.order.getStatus());

        for (int i = 0; i < 4; i++) {

            Assertions.assertNotEquals("ORDER_DELIVERED", this.order.getStatus());

            messagingService.sendMessage(this.messages.get(i));
            messagingService.sendMessage(this.messages.get(i + 1));

            // check traveler's message have all their properties
            Assertions.assertNotNull(this.messages.get(i).getFrom());
            Assertions.assertNotNull(this.messages.get(i).getTime());
            Assertions.assertNotNull(this.messages.get(i).getMessageContent());

            updateOrderStepsService.updateOrderStatus(this.order);
        }

        Assertions.assertEquals("ORDER_DELIVERED", this.order.getStatus());

        Assertions.assertEquals(8, this.messages.size());
    }
}
