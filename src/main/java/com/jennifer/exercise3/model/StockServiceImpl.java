package com.jennifer.exercise3.model;

import com.jennifer.exercise3.model.response.StockService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl  implements StockService {
    private static final Logger LOG = LoggerFactory.getLogger(StockServiceImpl.class);
    private final List<Stock> stocks = new ArrayList<>();
    private long nextId = 1;

    @Override
    public Stock createStock(Stock stock) {
        try {
            // Generate id and timestamps
            long id = nextId++;
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            stock.setId(id);
            stock.setCreateDate(currentTime);
            stock.setLastUpdate(currentTime);

            stocks.add(stock);
            return stock;
        } catch (Exception e) {
            LOG.error("Failed to create stock", e);
            throw new RuntimeException("Failed to create stock", e);
        }
    }


    @PostConstruct
    public void initializeStocks() {
        // Populate the list of stocks with initial data
        createStock(new Stock(1L,"Stock1", new BigDecimal("100.00")));
        createStock(new Stock(2L,"Stock2", new BigDecimal("150.00")));
        createStock(new Stock(3L, "Stock3", new BigDecimal("200.00")));
        createStock(new Stock(4L,"Stock4", new BigDecimal("250.00")));
        createStock(new Stock(5L,"Stock5", new BigDecimal("300.00")));

    }
}
