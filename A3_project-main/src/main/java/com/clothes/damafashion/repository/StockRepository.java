package com.clothes.damafashion.repository;

import com.clothes.damafashion.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Stock repository.
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
