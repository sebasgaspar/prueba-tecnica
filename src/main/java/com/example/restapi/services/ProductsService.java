package com.example.restapi.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.restapi.models.HistoryModel;
import com.example.restapi.models.ProductsModel;
import com.example.restapi.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productRepository;
    @Autowired
    HistoryRedisService historyRedisService;

    public ProductsModel saveProduct(ProductsModel product) {
        return productRepository.save(product);
    }

    public Page<Map<String, Object>> getByNameLike(String search, int page) {
        Pageable pagination = PageRequest.of(page, 10);
        Page<Map<String, Object>> pageProducts;
        pageProducts = productRepository.searchByNameContainingIgnoreCase(search, pagination);
        List<Map<String, Object>> products = pageProducts.getContent();
        this.createHistory(products);
        return pageProducts;
    }

    public ArrayList<Map<String, Object>> getPopular() {
        HashMap<Integer, Integer> idsHash = this.getPopularProducts();
        List<Integer> ids = new ArrayList<Integer>();
        idsHash.forEach((key, value) -> ids.add(key));
        ArrayList<Map<String, Object>> results = this.productRepository.findByIdsList(ids);
        if (results == null) {
            return null;
        } else {
            return results;
        }
    }

    public Optional<ProductsModel> getById(Long id) {
        return productRepository.findById(id);
    }

    private void createHistory(List<Map<String, Object>> results) {
        List<Integer> ids = new ArrayList<Integer>();
        results.forEach(MapProduct -> ids.add(Integer.parseInt(MapProduct.get("id").toString())));
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime date = LocalDateTime.now();
        String textDate = dateFormat.format(date);
        HistoryModel history = new HistoryModel(textDate, ids);
        this.historyRedisService.createHistory(history);
    }

    private HashMap<Integer, Integer> getPopularProducts() {
        HashMap<Integer, Integer> repetitions = new HashMap<Integer, Integer>();
        Map<String, HistoryModel> history = this.historyRedisService.findAll();
        history.forEach((key, value) -> {
            List<Integer> ids = value.getIdsProducts();
            for (int i = 0; i < ids.size(); ++i) {
                int id = ids.get(i);
                if (repetitions.containsKey(id))
                    repetitions.put(id, repetitions.get(id) + 1);
                else
                    repetitions.put(id, 1);
            }
        });
        HashMap<Integer, Integer> sortByRepetion = repetitions.entrySet().stream()
                .sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed())).limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortByRepetion;
    }
}
