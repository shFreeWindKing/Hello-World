package com.shptchangfeng.eastdemo.config;

import com.shptchangfeng.eastdemo.common.utils.DateUtil;
import com.shptchangfeng.eastdemo.dto.DicStaffDTO;
import com.shptchangfeng.eastdemo.po.DicStaff;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfig {
    @Bean
    public DozerBeanMapper mapper() {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        BeanMappingBuilder configure = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(DicStaff.class, DicStaffDTO.class, TypeMappingOptions.dateFormat(DateUtil.TIMEFORMAT));
            }
        };
        dozerBeanMapper.addMapping(configure);
        return dozerBeanMapper;
    }
}
