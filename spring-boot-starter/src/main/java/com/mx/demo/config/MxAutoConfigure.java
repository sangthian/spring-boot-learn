package com.mx.demo.config;

import com.mx.demo.properties.MxProperties;
import com.mx.demo.service.MxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 表示这是一个配置类
@Configuration
// 只有在classpath中找到MxService类的情况下，才会解析此自动配置类，否则不解析。
@ConditionalOnClass(MxService.class)
// 启用名为MxProperties的配置类，将其注入到容器
@EnableConfigurationProperties(MxProperties.class)

public class MxAutoConfigure {
    @Autowired
    private MxProperties mxProperties;

    @Bean
    // 只有当上下文中不存在MxService实例的时候，才会执行注入，确保是单例模式
    @ConditionalOnMissingBean(MxService.class)
    // 当应用配置文件中有相关的配置才会执行其所注解的代码块。
    @ConditionalOnProperty(prefix = "example.mx", value = "enabled", havingValue = "true")
    MxService mxService() {
        return new MxService(mxProperties);
    }

}
