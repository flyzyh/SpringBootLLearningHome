package com.zyh.springbtest.test1.controller;

import com.google.gson.Gson;
import com.zyh.springbtest.test1.vo.NodeTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/sayHi")
    public String sayHi(){
        Gson gson = new Gson();
        NodeTest nodeTest = new NodeTest("syp","18");
        gson.toJson(nodeTest);
        return gson.toString();
    }

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "hello";
    }
}
