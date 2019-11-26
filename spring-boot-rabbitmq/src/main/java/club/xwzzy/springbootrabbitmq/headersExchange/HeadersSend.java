package club.xwzzy.springbootrabbitmq.headersExchange;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author by xw
 * @Description TODO
 */
@Component
public class HeadersSend {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendTest(Map<String,Object> head,String msg)
    {
        System.out.println("send message" + msg);
        rabbitTemplate.convertAndSend("headersExchange1","test.headers.queue",getMessage(head,msg));
    }

    private Message getMessage(Map<String, Object> head, Object msg){
        MessageProperties messageProperties = new MessageProperties();
        for (Map.Entry<String, Object> entry : head.entrySet()) {
            messageProperties.setHeader(entry.getKey(), entry.getValue());
        }
        MessageConverter messageConverter = new SimpleMessageConverter();
        return messageConverter.toMessage(msg, messageProperties);
    }
}
