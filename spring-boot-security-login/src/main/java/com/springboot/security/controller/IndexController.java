package com.springboot.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 向往
 * @Contact: 2457081614@qq.com
 * @Date: 2019/11/11 0011 21:48
 * @Version: 1.0
 * @Description:
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        System.out.println("in======>index");
        return "index";
    }

    @GetMapping("/session/invalid")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public String sessionInvalid() {
        return "session已失效，请重新认证";
    }

    @GetMapping("/signout/success")
    @ResponseBody
    public String signout() {
        return "退出成功，请重新登录";
    }


   /* @PostMapping("/login")
    public String login() {
        return "login";
    }*/

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "admin权限啊";
    }
}