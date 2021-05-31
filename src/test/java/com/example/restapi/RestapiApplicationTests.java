package com.example.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.restapi.models.HistoryModel;
import com.example.restapi.services.HistoryRedisService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestapiApplicationTests {
	@Autowired
	HistoryRedisService historyRedisService;

	@Test
	void contextLoads() {
	}

	@Test
	void historyRedisCreate() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		HistoryModel history = new HistoryModel("12/12/2020", ids);
		this.historyRedisService.createHistory(history);
	}

	@Test
	void historyFindAll() {
		Map<String, HistoryModel> result = this.historyRedisService.findAll();
		result.forEach((key, value) -> System.out.println(key + ":" + value.getIdsProducts().toString()));
	}

}
