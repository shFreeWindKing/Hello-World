package com.shptchangfeng.eastdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
/* 类注解 */
@Api(value = "Demo of Hello Controller", tags = {"Demo of Hello Controller"})
public class HelloController {
    /* 方法注解 */
    @ApiOperation(value = "desc of say", notes = "sayHello")
    @PostMapping("/say")
    public String sayHello(/*参数注解*/ @ApiParam(value = "传入名字", required = true) @RequestParam String name) {
        return name.toUpperCase() + ":Hello,this is my first springboot demo,thanks.";
    }
}