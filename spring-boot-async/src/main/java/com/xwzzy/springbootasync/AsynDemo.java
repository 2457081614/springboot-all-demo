package com.xwzzy.springbootasync;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


@Component
public class AsynDemo {

    @Async
    public  void test() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("异步任务");
    }

    @Async
    public Future<String> test1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return new AsyncResult<>("return value");
    }
}
