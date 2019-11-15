package com.xwzzy.springbootasync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author by yangliu@tiduyun.com
 * @Description TODO
 */
@Component
public class AsynTest implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private AsynDemo asynDemo;

    @Override
    public void run(String... args) throws Exception {
        AsynTest proxyAsyTest = applicationContext.getBean(AsynTest.class);
        System.out.println("start");
        asynDemo.test();
        System.out.println("end");
        Future future = asynDemo.test1();
        System.out.println(future.get());
    }

}
