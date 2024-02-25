package com.anuj.asn3.services;

import java.util.List;

import com.anuj.asn3.model.BloodStock;

public interface BloodStockServices {

	List<BloodStock> getAllBloodStocks();

	BloodStock getBloodStockById(Long id);

	BloodStock addBloodStock(BloodStock bloodStock);

	BloodStock updateBloodStock(Long id, BloodStock bloodStock);

	void deleteBloodStock(Long id);
}
