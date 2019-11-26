package club.xwzzy.springbootrabbitmq.headersExchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by xw
 * @Description TODO
 */
@Component
public class HeadersConfig {

    @Bean
    public Queue testQueue() {
        return new Queue("test.headers.queue");
    }

    @Bean
    public HeadersExchange headersExchange1() {
        return new HeadersExchange("headersExchange1");
    }

    @Bean
    public HeadersExchange headersExchange2() {
        return new HeadersExchange("headersExchange2");
    }

    @Bean
    public Binding bindingHeadersExchange1(Queue testQueue,HeadersExchange headersExchange1)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("type","test");
        map.put("type2","全部匹配");
        return BindingBuilder.bind(testQueue).to(headersExchange1).whereAll(map).match();
    }
}
