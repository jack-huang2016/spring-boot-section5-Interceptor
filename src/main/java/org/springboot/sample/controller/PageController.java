package org.springboot.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @RequestMapping(value = "/page/index")
    public String index(){
        return "进去拦截器的controller";
    }

}
