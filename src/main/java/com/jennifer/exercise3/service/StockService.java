package com.jennifer.exercise3.service;

import com.jennifer.exercise3.model.Stock;

import java.math.BigDecimal;

public interface StockService {
    Stock createStock(Stock stock);

    Stock getStockById(Long id);

}
