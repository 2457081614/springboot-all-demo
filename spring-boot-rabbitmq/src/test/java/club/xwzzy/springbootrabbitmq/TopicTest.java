package club.xwzzy.springbootrabbitmq;

import club.xwzzy.springbootrabbitmq.topicExchange.TopicSender;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author by xw
 * @Description TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRabbitmqApplication.class)
public class TopicTest {

    @Autowired
    private TopicSender topicSender;

    @Test
    public void send1() throws InterruptedException {
        topicSender.send1();
        Thread.sleep(30000);
    }
    @Test
    public void send2() throws InterruptedException {
        topicSender.send2();
        Thread.sleep(30000);
    }

}
