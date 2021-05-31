package com.example.restapi.config;

import java.net.URI;

import com.example.restapi.models.HistoryModel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
    // @Bean
    // JedisConnectionFactory jedisConnectionFactory() {
    // return new JedisConnectionFactory();
    // }

    @Bean
    public JedisConnectionFactory connectionFactory() {
        try {
            JedisConnectionFactory redis = new JedisConnectionFactory();
            String redisUrl = "redis://:p812eef3f3d162e8db0bdbdc4dd041acf63f36a1daa09f04bd95f9d5054135bef@ec2-3-212-83-228.compute-1.amazonaws.com:15119";
            URI redisUri = new URI(redisUrl);
            redis.setHostName(redisUri.getHost());
            redis.setPort(redisUri.getPort());
            redis.setPassword(redisUri.getUserInfo().split(":", 2)[1]);
            return redis;
        } catch (Exception e) {
            return null;
        }
    }

    @Bean
    RedisTemplate<String, HistoryModel> redisTemplate(RedisConnectionFactory connectionFactory) {
        final RedisTemplate<String, HistoryModel> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory());
        return redisTemplate;
    }
}
