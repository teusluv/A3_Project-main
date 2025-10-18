package com.clothes.damafashion.service;

import com.clothes.damafashion.entity.Supplier;
import com.clothes.damafashion.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The type Supplier service.
 */
@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    /**
     * Instantiates a new Supplier service.
     *
     * @param supplierRepository the supplier repository
     */
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Supplier> findById(Long id) {
        return supplierRepository.findById(id);
    }

    /**
     * Save supplier.
     *
     * @param supplier the supplier
     * @return the supplier
     */
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    /**
     * Update optional.
     *
     * @param id          the id
     * @param newSupplier the new supplier
     * @return the optional
     */
    public Optional<Supplier> update(Long id, Supplier newSupplier) {
        return supplierRepository.findById(id).map(supplier -> {
            supplier.setName(newSupplier.getName());
            supplier.setContact(newSupplier.getContact());
            return supplierRepository.save(supplier);
        });
    }

    /**
     * Delete boolean.
     *
     * @param id the id
     * @return the boolean
     */
    @Transactional
    public boolean delete(Long id) {
        if (supplierRepository.existsById(id)) {
            supplierRepository.deleteById(id);
            return true;
        }
        return false;
    }
}