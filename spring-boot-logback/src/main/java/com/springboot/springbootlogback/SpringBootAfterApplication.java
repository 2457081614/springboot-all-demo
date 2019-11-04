package com.springboot.springbootlogback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author by yangliu@tiduyun.com
 * @Description TODO
 */
@Slf4j
@Component
public class SpringBootAfterApplication implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("info级别日志");
        log.debug("debug级别日志");
        log.trace("trace级别日志");
    }
}
