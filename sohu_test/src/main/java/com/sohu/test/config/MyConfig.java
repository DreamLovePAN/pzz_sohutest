package com.sohu.test.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MyConfig {

    /*
    * 驼峰命名
    * */
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer(){

            @Override
            public void customize(Configuration configuration) {
                //驼峰命名规则
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}

