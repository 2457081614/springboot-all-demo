package club.xwzzy.springbootrabbitmq.fanoutExchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author by xw
 * @Description TODO
 */
@Component
@RabbitListener(queues = {"fanout.A","fanout.B","fanout.C"})
public class FanoutReceiver {
    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver  : " + message);
    }
}
