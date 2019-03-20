package com.teligen.dy.javabase.concurrent.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/concurrent")
public class ConcurrentAction {
    @GetMapping("/test")
    public String test(){
        return "hello world";
    }

}
