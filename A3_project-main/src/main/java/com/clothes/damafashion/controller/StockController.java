package com.clothes.damafashion.controller;

import com.clothes.damafashion.controller.dto.StockCreationDto;
import com.clothes.damafashion.controller.dto.StockResponseDto;
import com.clothes.damafashion.entity.Stock;
import com.clothes.damafashion.service.ProductService;
import com.clothes.damafashion.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Stock controller.
 */
@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;
    private final ProductService productService;

    /**
     * Instantiates a new Stock controller.
     *
     * @param stockService the stock service
     */
    @Autowired
    public StockController(StockService stockService, ProductService productService) {
        this.stockService = stockService;
        this.productService = productService;
    }

    /**
     * Gets all stocks.
     *
     * @return the all stocks
     */
    @GetMapping
    public ResponseEntity<List<StockResponseDto>> getAllStocks() {
        List<StockResponseDto> stocks = stockService.findAll().stream()
            .map(StockResponseDto::fromEntity)
            .toList();
        return ResponseEntity.ok(stocks);
    }

    /**
     * Gets stock by product id.
     *
     * @param productId the product id
     * @return the stock by product id
     */
    @GetMapping("/{productId}")
    public ResponseEntity<StockResponseDto> getStockByProductId(@PathVariable Long productId) {
        return stockService.findByProductId(productId)
                .map(StockResponseDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Update stock response entity.
     *
     * @param productId     the product id
     * @param stockQuantity the stock quantity
     * @return the response entity
     */
    @PutMapping("/{productId}")
    public ResponseEntity<StockResponseDto> updateStock(@PathVariable Long productId, @RequestBody Integer stockQuantity) {
        return stockService.updateQuantity(productId, stockQuantity)
                .map(StockResponseDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create or update stock stock.
     *
     * @param stockCreationDto the stock creation dto
     * @return the stock
     */
    @PostMapping
    public StockResponseDto createStock(@RequestBody StockCreationDto stockCreationDto) {

        Stock savedStock = stockService.save(stockCreationDto.toEntity(productService));
        return StockResponseDto.fromEntity(savedStock);
    }

    /**
     * Delete stock response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        if (stockService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}