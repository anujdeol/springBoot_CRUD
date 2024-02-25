package com.anuj.asn3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.asn3.model.BloodBank;
import com.anuj.asn3.services.impl.BloodBankServiceImpl;

@RestController
@RequestMapping("/bloodbank")
public class BloodBankController {
	@Autowired
	private BloodBankServiceImpl bloodBankService;

	@Autowired
	public BloodBankController(BloodBankServiceImpl bloodBankService) {
		this.bloodBankService = bloodBankService;
	}

	@GetMapping
	public List<BloodBank> getAllBloodStocks() {
		return bloodBankService.getAllBloodBank();
	}

	@GetMapping("/{id}")
	public BloodBank getBloodStockById(@PathVariable Long id) {
		return bloodBankService.getBloodBankById(id);
	}

	@PostMapping
	public BloodBank addBloodStock(@RequestBody BloodBank bloodBank) {
		return bloodBankService.addBloodBank(bloodBank);
	}

	@PatchMapping("/{id}")
	public BloodBank updateBloodStock(@PathVariable Long id, @RequestBody BloodBank bloodBank) {
		return bloodBankService.updateBloodBank(id, bloodBank);
	}

	@DeleteMapping("/{id}")
	public void deleteBloodStock(@PathVariable Long id) {
		bloodBankService.deleteBloodBank(id);
	}

}
