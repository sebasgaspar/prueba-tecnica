package com.example.restapi.repository;

import java.util.Map;

import com.example.restapi.models.HistoryModel;

public interface RedisRepository {
    Map<String, HistoryModel> findAll();
    void save(HistoryModel history);
}
