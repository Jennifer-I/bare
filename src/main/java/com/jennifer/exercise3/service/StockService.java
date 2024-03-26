package com.jennifer.exercise3.service;

import com.jennifer.exercise3.model.Stock;

import java.math.BigDecimal;
import java.util.List;

public interface StockService {
    Stock createStock(Stock stock);

    Stock getStockById(Long id);

    List<Stock> getAllStocks();

    Stock updateStockPrice(Long id, BigDecimal newPrice);
}
