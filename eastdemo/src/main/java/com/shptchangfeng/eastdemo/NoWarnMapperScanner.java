package com.shptchangfeng.eastdemo;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoWarnMapperScanner {
    // 解决启动类Warn信息 https://my.oschina.net/kevin2kelly/blog/2046324
    //org.mybatis.spring.mapper.ClassPathMapperScanner
    // No MyBatis mapper was found in '[com.shptchangfeng.eastdemo]' package. Please check your configuration.
}
