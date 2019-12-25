package org.springboot.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @RequestMapping(value = "/page/index")
    public String index(){
        return "index方法的进去拦截器的controller";
    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login方法的进去拦截器的controller";
    }

}
