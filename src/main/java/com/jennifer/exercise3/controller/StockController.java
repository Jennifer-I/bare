package com.jennifer.exercise3.controller;


import com.jennifer.exercise3.Exception.StockNotFoundException;
import com.jennifer.exercise3.model.Stock;
import com.jennifer.exercise3.response.ApiResponse;
import com.jennifer.exercise3.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Stock>>> getAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK, "Stocks retrieved successfully", stocks), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Stock>> getStockById(@PathVariable Long id) {
        try {
            Stock stock = stockService.getStockById(id);
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK, "Stock retrieved successfully", stock), HttpStatus.OK);
        } catch (StockNotFoundException e) {
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.NOT_FOUND, e.getMessage(), null), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Stock>> updateStockPrice(@PathVariable Long id, @RequestParam BigDecimal newPrice) {
        try {
            Stock updatedStock = stockService.updateStockPrice(id, newPrice);
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.OK, "Stock price updated successfully", updatedStock), HttpStatus.OK);
        } catch (StockNotFoundException e) {
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.NOT_FOUND, e.getMessage(), null), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Stock>> createStock(@RequestBody Stock stock) {
        try {
            Stock createdStock = stockService.createStock(stock);
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.CREATED, "Stock created successfully", createdStock), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
