package com.example.restapi.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.restapi.models.ProductsModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductsRepository extends CrudRepository<ProductsModel, Long> {

    public static final String QUERY_MAP_SIMPLE_PRODUCT = "SELECT id AS id , name AS name, price AS price, discount_price AS discountPrice, percent AS percent,"
            + "image AS image, background_image AS backgroundImage FROM products ";

    @Query(value = QUERY_MAP_SIMPLE_PRODUCT
            + "WHERE products.name LIKE CONCAT('%', UPPER(?1), '%')", countQuery = "SELECT COUNT(*) FROM products  WHERE products.name LIKE CONCAT('%', UPPER(?1), '%')", nativeQuery = true)
    Page<Map<String, Object>> searchByNameContainingIgnoreCase(String search, Pageable pageable);

    @Query(value = QUERY_MAP_SIMPLE_PRODUCT + " WHERE id in ?1", nativeQuery = true)
    ArrayList<Map<String, Object>> findByIdsList(List<Integer> productsId);

}
