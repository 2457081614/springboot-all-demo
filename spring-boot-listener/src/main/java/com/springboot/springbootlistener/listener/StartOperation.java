package com.springboot.springbootlistener.listener;

import com.springboot.springbootlistener.event.TestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author by yangliu@tiduyun.com
 * @Description TODO
 */
@Component
public class StartOperation implements CommandLineRunner {


    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("开始执行");
        applicationContext.publishEvent(new TestEvent(new Object()));
    }
}
