package club.xwzzy.springbootrabbitmq;

import club.xwzzy.springbootrabbitmq.headersExchange.HeadersSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author by xw
 * @Description TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRabbitmqApplication.class)
public class HeadersTest {

    @Autowired
    private HeadersSend headersSend;

    @Test
    public void test() throws InterruptedException {
        Map<String,Object> map = new HashMap<>();
        map.put("type","test");
        map.put("type1","test");
        headersSend.sendTest(map,"hello world");
        TimeUnit.SECONDS.sleep(10);

    }
}
