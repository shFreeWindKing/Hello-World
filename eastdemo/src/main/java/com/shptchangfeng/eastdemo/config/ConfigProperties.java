package com.shptchangfeng.eastdemo.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class ConfigProperties {

    @Value("${mail.user:xdj}")
    private String mailUser;
//    @Value("${name}")
//    private String name;
//    @Value("${mysql.host}")
//    private String mysqlHost;
//    @Value("${mysql.port}")
//    private Integer mysqlPort;
//    @Value("${mysql.username}")
//    private String mysqlUsername;
//    @Value("${mysql.password}")
//    private String mysqlPassword;
}