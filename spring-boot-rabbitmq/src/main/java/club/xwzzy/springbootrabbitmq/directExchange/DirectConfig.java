package club.xwzzy.springbootrabbitmq.directExchange;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author by xw
 * @Description TODO
 */
@Component
public class DirectConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
