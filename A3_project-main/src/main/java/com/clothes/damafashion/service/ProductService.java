package com.clothes.damafashion.service;

import com.clothes.damafashion.entity.Product;
import com.clothes.damafashion.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The type Product service.
 */
@Service
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Instantiates a new Product service.
     *
     * @param productRepository the product repository
     */
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Find all lists.
     *
     * @return the list
     */
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Save product.
     *
     * @param product the product
     * @return the product
     */
    public Product save(Product product) {
        return productRepository.save(product);
    }

    /**
     * Update optional.
     *
     * @param id         the id
     * @param newProduct the new product
     * @return the optional
     */
    public Optional<Product> update(Long id, Product newProduct) {
        return productRepository.findById(id).map(product -> {
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
            product.setDescription(newProduct.getDescription());
            product.setCategory(newProduct.getCategory());
            product.setSupplier(newProduct.getSupplier());
            return productRepository.save(product);
        });
    }

    /**
     * Delete boolean.
     *
     * @param id the id
     */
    @Transactional
    public boolean delete(Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return true;
                })
                .orElse(false);
    }
}