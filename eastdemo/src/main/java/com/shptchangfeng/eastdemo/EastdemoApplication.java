package com.shptchangfeng.eastdemo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

/**
 * 启动程序
 * @SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) 不需要配置数据源的意思
 * 如果需要用到数据库请将exclude去掉
 */
@EnableApolloConfig
//@EnableEurekaClient 从Spring Cloud Edgware开始，@EnableEurekaClient 或 @EnableDiscoveryClient 是可省略的。只需加上相关依赖
@Configuration
@SpringBootApplication
@MapperScan(basePackages = {"com.shptchangfeng.eastdemo.dao"})
//@SpringBootApplication(exclude={HibernateJpaAutoConfiguration.class})
public class EastdemoApplication {
    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(EastdemoApplication.class, args);
//        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//        List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT * FROM epm_demand limit 20");
//        for(Map<String, Object> map : result) {
//            System.out.println(map);
//        }
//        //设置apollo启动环境 暂时固定
//        System.setProperty("env", "DEV");
        SpringApplication.run(EastdemoApplication.class, args);
    }

}
