package com.jennifer.exercise3.model;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stock {

    private Long id;
    private String name;
    private BigDecimal currentPrice;
    private Timestamp createDate;
    private Timestamp lastUpdate;

    public Stock(Long id, String name, BigDecimal currentPrice) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public Stock(String name, BigDecimal currentPrice) {
        this.name = name;
        this.currentPrice = currentPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id) &&
                Objects.equals(name, stock.name) &&
                Objects.equals(currentPrice, stock.currentPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, currentPrice);
    }
}
