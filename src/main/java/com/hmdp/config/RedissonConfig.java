package com.hmdp.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {
        // 1. 创建配置对象
        Config config = new Config();
        // 2. 替换为自己的虚拟机 Redis IP + 密码（关键修改）
        // 格式：redis://密码@IP:端口
        config.useSingleServer()
                .setAddress("redis://192.168.136.73:6379")  // 改IP：从127.0.0.1换成虚拟机IP
                .setPassword("123456");  // 加密码：和你Redis的密码一致

        // 3. 创建Redisson客户端
        return Redisson.create(config);
    }
}