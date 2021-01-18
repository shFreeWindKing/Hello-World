package com.shptchangfeng.eastdemo.config;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApolloPropertiesRefresher implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @ApolloConfigChangeListener("demo.eastdemo")
    public void onChange(ConfigChangeEvent changeEvent) {
        refreshTaskScheduleProperties(changeEvent);
    }

    private void refreshTaskScheduleProperties(ConfigChangeEvent changeEvent) {
        log.info("Refreshing TaskSchedule properties: {}", changeEvent.changedKeys());
        // 更新相应的bean的属性值，主要是存在@ConfigurationProperties注解的bean
//        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
        log.info("Changes for namespace " + changeEvent.getNamespace());
        for (String key : changeEvent.changedKeys()) {
            ConfigChange change = changeEvent.getChange(key);
            System.out.println(String.format("Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
        }
        log.info("TaskSchedule properties refreshed!");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}