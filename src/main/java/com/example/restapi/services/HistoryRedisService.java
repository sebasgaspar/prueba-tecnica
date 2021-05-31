package com.example.restapi.services;

import java.util.Map;

import com.example.restapi.models.HistoryModel;
import com.example.restapi.repository.HistoryRedisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryRedisService {
    @Autowired
    HistoryRedisRepository historyRedisRepository;

    public Map<String, HistoryModel> findAll() {
        return historyRedisRepository.findAll();
    }

    public void createHistory(HistoryModel history) {
        historyRedisRepository.save(history);
    }
}
