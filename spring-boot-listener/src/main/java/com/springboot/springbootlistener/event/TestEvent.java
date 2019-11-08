package com.springboot.springbootlistener.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author by yangliu@tiduyun.com
 * @Description TODO
 */
public class TestEvent extends ApplicationEvent {

    public TestEvent(Object source) {
        super(source);
    }
}
