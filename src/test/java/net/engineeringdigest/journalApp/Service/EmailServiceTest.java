package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    EmailService emailService;

    @Test
    public void testSendEmail() {
        emailService.sendEmail("chinmaynaik02@gmail.com",
                "Testing Java Mail Sender",
                "Chinmay Naik, How are you?");
    }
}
