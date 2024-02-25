package com.anuj.asn3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.asn3.model.BloodStock;
import com.anuj.asn3.services.impl.BloodStockServiceImpl;
import com.anuj.asn3.services.impl.PatientServicesImpl;

@RestController
@RequestMapping("/bloodstock")
public class BloodStockController {
	

		@Autowired
		private BloodStockServiceImpl bloodStockService;

		@Autowired
		public BloodStockController(BloodStockServiceImpl bloodStockService) {
			this.bloodStockService = bloodStockService;
		}

	    @GetMapping
	    public List<BloodStock> getAllBloodStocks() {
	        return bloodStockService.getAllBloodStocks();
	    }

	    @GetMapping("/{id}")
	    public BloodStock getBloodStockById(@PathVariable Long id) {
	        return bloodStockService.getBloodStockById(id);
	    }

	    @PostMapping
	    public BloodStock addBloodStock(@RequestBody BloodStock bloodStock) {
	        return bloodStockService.addBloodStock(bloodStock);
	    }

	    @PatchMapping("/{id}")
	    public BloodStock updateBloodStock(@PathVariable Long id, @RequestBody BloodStock bloodStock) {
	        return bloodStockService.updateBloodStock(id, bloodStock);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteBloodStock(@PathVariable Long id) {
	        bloodStockService.deleteBloodStock(id);
	    }

}
