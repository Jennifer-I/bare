package com.jennifer.exercise3.model.controller;

import com.jennifer.exercise3.model.Stock;
import com.jennifer.exercise3.model.response.ApiResponse;
import com.jennifer.exercise3.model.response.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("stock")
public class StockController {


    private final StockService stockService;

    @PostMapping("/createStock")
    public ResponseEntity<ApiResponse<Stock>> createStock(@RequestBody Stock stock) {
        try {
            Stock createdStock = stockService.createStock(stock);
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.CREATED, "Stock created successfully", createdStock), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}