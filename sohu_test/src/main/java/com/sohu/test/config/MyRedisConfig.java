package com.sohu.test.config;

import com.sohu.test.bean.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class MyRedisConfig {

    /*
    * 定义序列化规则 json
    * */
    @Bean
    public RedisTemplate<Object, Department> departmentRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {

        RedisTemplate<Object,Department> redisTemplate=new RedisTemplate<Object,Department>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Department> departmentSerializer=new Jackson2JsonRedisSerializer<Department>(Department.class);
        redisTemplate.setDefaultSerializer(departmentSerializer);
        return redisTemplate;
    }
}
