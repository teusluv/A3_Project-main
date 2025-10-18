package com.clothes.damafashion.repository;

import com.clothes.damafashion.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Supplier repository.
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
