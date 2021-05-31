package com.example.restapi.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.example.restapi.models.ProductsModel;
import com.example.restapi.services.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductsService productService;

    @PostMapping
    public ProductsModel saveProduct(@RequestBody ProductsModel product) {
        return this.productService.saveProduct(product);
    }

    @GetMapping("/query")
    public ResponseEntity<Map<String, Object>> getProductByNameLike(@RequestParam("search") String search,@RequestParam("pagination") int page) {
        try {
            Page<Map<String, Object>> pageProducts = this.productService.getByNameLike(search,page);
            Map<String, Object> response = new HashMap<>();
            response.put("products", pageProducts.getContent());
            response.put("totalPages", pageProducts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductsModel> getProductById(@PathVariable("id") Long id) {
        return this.productService.getById(id);
    }

    @GetMapping("/popular")
    public ArrayList<Map<String, Object>> getPopular() {
        return this.productService.getPopular();
    }
}
