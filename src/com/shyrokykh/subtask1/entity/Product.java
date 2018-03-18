package com.shyrokykh.subtask1.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final String name;
    private BigDecimal price;

    public Product(String name, double price) {
        this.name = name;
        this.price = new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;

        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public BigDecimal getPrice() {
        return price;
    }
}
