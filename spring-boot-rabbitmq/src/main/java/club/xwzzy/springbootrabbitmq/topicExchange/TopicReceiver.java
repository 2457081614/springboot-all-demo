package club.xwzzy.springbootrabbitmq.topicExchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author by xw
 * @Description TODO
 */
@Component
@RabbitListener(queues = {"topic.message","topic.messages"})
public class TopicReceiver {
    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic Receiver  : " + message);
    }
}