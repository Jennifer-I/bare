package com.jennifer.exercise3.service;



import com.jennifer.exercise3.model.Stock;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
class StockServiceImplTest {

    @Mock
    private List<Stock> stocks;

    @InjectMocks
    private StockServiceImpl stockService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        log.info("call initialize stock before each test ");
        stockService.initializeStocks();
    }


    @Test
    void createStock_shouldCreateNewStock() {
        log.info("arrange");
        Stock newStock = new Stock(1L,"Stock1", new BigDecimal("100.00"));
        when(stocks.add(any())).thenReturn(true);

        log.info("act");
        Stock result = stockService.createStock(newStock);

        log.info("assert");
        assertEquals(newStock, result);
    }
}
