package club.xwzzy.springbootrabbitmq;

import club.xwzzy.springbootrabbitmq.fanoutExchange.FanoutSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author by xw
 * @Description TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRabbitmqApplication.class)
public class FanoutTest {


    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void test() throws InterruptedException {
        fanoutSender.send();
        TimeUnit.SECONDS.sleep(100);
    }
}
