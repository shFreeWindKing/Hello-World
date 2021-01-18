package com.shptchangfeng.eastdemo.controller;

import com.ctrip.framework.apollo.ConfigService;
import com.shptchangfeng.eastdemo.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController

public class ConfigController {

    @Autowired
    private ConfigProperties configProperties;

    @Value("${mail.user}")
    private String mailUser;

    @GetMapping("/mailuser")
    public String getMailUser() {
        String property  = ConfigService.getConfig("demo.eastdemo").getProperty("mail.user", "1");
        return property;
    }

    @GetMapping("/apollo")
    public Map<String, String> getMySQLProperties() {
        Map<String, String> result = new HashMap<>();
//        result.put("host", configProperties.getMysqlHost());
        result.put("mail.user", configProperties.getMailUser());
        return result;
//        // JDK9中的新特性，快速创建只读集合。
//        return Map.of("host", configProperties.getMysqlHost(),
//                "port", configProperties.getMysqlPort(),
//                "username", configProperties.getMysqlUsername(),
//                "password", configProperties.getMysqlPassword());
    }

}