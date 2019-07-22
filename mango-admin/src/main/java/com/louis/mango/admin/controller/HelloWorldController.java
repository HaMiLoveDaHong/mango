package com.louis.mango.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author soft
 * @since 2019/7/22
 */
@RestController
@RequestMapping
public class HelloWorldController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return "hello world!";
    }

    @RequestMapping(value = "/bye")
    @ResponseBody
    public String bye(){
        return "bye bye!";
    }

}
