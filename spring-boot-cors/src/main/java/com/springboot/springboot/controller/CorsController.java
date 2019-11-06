package com.springboot.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author by yangliu@tiduyun.com
 * @Description TODO
 */
@Controller
public class CorsController {

    @RequestMapping(value = "index")
    public String index() {
        return "index";
    }

    @RequestMapping("hello")
    @ResponseBody
    @CrossOrigin(value = "xw.test")
    public String hello() {
        return "hello";
    }
}
