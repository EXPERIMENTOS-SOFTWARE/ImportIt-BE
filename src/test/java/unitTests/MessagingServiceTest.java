package unitTests;

import com.mirai.importback.entities.Users;
import com.mirai.importback.services.impl.MessagingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MessagingServiceTest {
    private Users user;
    private Users traveler;
    private MessagingService messagingService;

    public MessagingServiceTest() {
        this.user = new Users();
        this.traveler = new Users();
        this.messagingService = new MessagingService();
    }

    @BeforeAll
    public void setup() {
        this.user.setName("Jeno Jibarez");
        this.traveler.setName("Jaemin Alcidez");
        this.messagingService.sendMessage(this.user.getName(), "Hello");
        this.messagingService.sendMessage(this.traveler.getName(), "Hi");
        this.messagingService.sendMessage(this.user.getName(), "How are you?");
        this.messagingService.sendMessage(this.traveler.getName(), "I'm fine, thanks.");
        this.messagingService.sendMessage(this.user.getName(), "How about you?");
        this.messagingService.sendMessage(this.traveler.getName(), "I'm fine too.");
        this.messagingService.sendMessage(this.user.getName(), "That's good to hear.");
        this.messagingService.sendMessage(this.traveler.getName(), "Yeah.");
        this.messagingService.sendMessage(this.user.getName(), "Bye.");
        this.messagingService.sendMessage(this.traveler.getName(), "Bye.");
    }

    @Test
    void testMessagesAreCreated() {
        Assertions.assertEquals(10, this.messagingService.getMessages().size());
    }

    @Test
    void testMessagesSentByTraveler() {
        Assertions.assertEquals(5, this.messagingService.filterMessagesByName(this.traveler.getName()).size());
    }

}
