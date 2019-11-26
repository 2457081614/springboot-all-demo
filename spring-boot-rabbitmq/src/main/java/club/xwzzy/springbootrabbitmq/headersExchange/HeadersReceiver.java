package club.xwzzy.springbootrabbitmq.headersExchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author by xw
 * @Description TODO
 */
@Component
@RabbitListener(queues={"test.headers.queue"})
public class HeadersReceiver {

    @RabbitHandler
    public void receiver(String msg)
    {
        System.out.println("接受消息:"+msg);

    }
}
