package com.example.restapi.repository;

import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import com.example.restapi.models.HistoryModel;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryRedisRepository implements RedisRepository {
    private static final String KEY = "HistorySearch";

    private RedisTemplate<String, HistoryModel> redisTemplate;
    private HashOperations<String, String, HistoryModel> hashOperations;

    public HistoryRedisRepository(RedisTemplate<String, HistoryModel> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, HistoryModel> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void save(HistoryModel history) {
        hashOperations.put(KEY, UUID.randomUUID().toString(), history);
    }
}
