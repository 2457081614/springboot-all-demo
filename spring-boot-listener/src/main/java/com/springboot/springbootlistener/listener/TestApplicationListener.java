package com.springboot.springbootlistener.listener;

import com.springboot.springbootlistener.event.TestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author by yangliu@tiduyun.com
 * @Description TODO
 */

@Component
public class TestApplicationListener implements ApplicationListener<TestEvent> {


    @Override
    @EventListener
    public void onApplicationEvent(TestEvent testEvent) {
        System.out.println("监听器测试");
    }
}
