package com.example.restapi.models;

import java.io.Serializable;
import java.util.List;

public class HistoryModel implements Serializable{
    private String date;
    private List<Integer> idsProducts;

    public HistoryModel(String date, List<Integer> idsProducts) {
        this.date = date;
        this.idsProducts = idsProducts;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public List<Integer> getIdsProducts() {
        return idsProducts;
    }
    public void setIdsProducts(List<Integer> idsProducts) {
        this.idsProducts = idsProducts;
    }

    
}
