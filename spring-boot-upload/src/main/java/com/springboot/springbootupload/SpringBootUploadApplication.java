package com.springboot.springbootupload;

import com.springboot.springbootupload.config.FileConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {FileConfig.class})
public class SpringBootUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootUploadApplication.class, args);
    }

}
