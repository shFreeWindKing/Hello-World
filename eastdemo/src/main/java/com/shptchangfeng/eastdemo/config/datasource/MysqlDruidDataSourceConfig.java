package com.shptchangfeng.eastdemo.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;

@Slf4j
@Configuration
//配置mapper扫描的包路径，注意MapperScan来源 tk.mybatis.spring.annotation.MapperScan
@MapperScan(basePackages = MysqlDruidDataSourceConfig.MAPPER_PACKAGE, sqlSessionFactoryRef = MysqlDruidDataSourceConfig.SESSION_FACTORY)
public class MysqlDruidDataSourceConfig {
    static final String SESSION_FACTORY = "mySqlSessionFactory";
    private static final String DATASOURCE_NAME = "mysqlDataSource";
    //mapper类的包路径
    static final String MAPPER_PACKAGE = "com.shptchangfeng.eastdemo.dao";
    //自定义mapper的xml文件路径
    private static final String MAPPER_XML_PATH = "classpath:/mysql-mapper/*.xml";
    //数据源配置的前缀，必须与application.properties中配置的对应数据源的前缀一致
    private static final String DATASOURCE_PREFIX = "spring.datasource";

    @Primary
    @Bean(name = DATASOURCE_NAME)
    @ConfigurationProperties(prefix = DATASOURCE_PREFIX)
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean(name = SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory() {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(druidDataSource());
        try {
            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            //自定义mapper的xml文件地址，当通用mapper提供的默认功能无法满足我们的需求时，可以自己添加实现，与mybatis写mapper一样
            sessionFactoryBean.setMapperLocations(resolver.getResources(MAPPER_XML_PATH));
            return sessionFactoryBean.getObject();
        } catch (Exception e) {
            log.error("配置demo的SqlSessionFactory失败，error:{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}