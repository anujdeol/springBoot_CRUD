package com.anuj.asn3.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.asn3.model.BloodStock;
import com.anuj.asn3.repos.BloodStockRepo;
import com.anuj.asn3.services.BloodStockServices;

import jakarta.transaction.Transactional;


@Service
public class BloodStockServiceImpl implements BloodStockServices {

	private final BloodStockRepo bloodStockRepo;

    @Autowired
    public BloodStockServiceImpl(BloodStockRepo bloodStockRepo) {
        this.bloodStockRepo = bloodStockRepo;
    }

    @Override
    public List<BloodStock> getAllBloodStocks() {
        return bloodStockRepo.findAll();
    }

    @Override
    public BloodStock getBloodStockById(Long id) {
        return bloodStockRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public BloodStock addBloodStock(BloodStock bloodStock) {
        return bloodStockRepo.save(bloodStock);
    }

    @Override
    public BloodStock updateBloodStock(Long id, BloodStock bloodStock) {
        BloodStock existingBloodStock = bloodStockRepo.findById(id).orElse(null);
        if (existingBloodStock != null) {
            existingBloodStock.setBloodGroup(bloodStock.getBloodGroup());
            existingBloodStock.setQuantity(bloodStock.getQuantity());
            existingBloodStock.setBestBeforeDate(bloodStock.getBestBeforeDate());
            existingBloodStock.setStatus(bloodStock.getStatus());

            // Save and return the updated blood stock
            return bloodStockRepo.save(existingBloodStock);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteBloodStock(Long id) {
        bloodStockRepo.deleteById(id);
    }

}
