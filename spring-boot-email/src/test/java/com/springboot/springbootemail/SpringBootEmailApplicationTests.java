package com.springboot.springbootemail;

import com.springboot.springbootemail.mail.SendSimpleMail;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = SpringBootEmailApplication.class)
@RunWith(value = SpringJUnit4ClassRunner.class)
class SpringBootEmailApplicationTests {

    @Autowired
    private SendSimpleMail sendSimpleMail;

    @Test
    public void testSimple()
    {
        sendSimpleMail.sendSimpleEmail();
    }

    @Test
    public void sendHtmlEmail()
    {
        sendSimpleMail.sendHtmlEmail();
    }

    @Test
    public void sendAttachmentsMail()
    {
        sendSimpleMail.sendAttachmentsMail();
    }

    @Test
    public void sendTempleteMail()
    {
        sendSimpleMail.sendTemplateEmail("hello");
    }

}
