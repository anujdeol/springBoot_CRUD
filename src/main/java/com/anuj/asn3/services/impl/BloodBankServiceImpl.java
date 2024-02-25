package com.anuj.asn3.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.asn3.model.BloodBank;
import com.anuj.asn3.model.BloodStock;
import com.anuj.asn3.repos.BloodBankRepo;
import com.anuj.asn3.services.BloodBankServices;

import jakarta.transaction.Transactional;

@Service
public class BloodBankServiceImpl implements BloodBankServices {

	private final BloodBankRepo bloodBankRepo;

	@Autowired
	public BloodBankServiceImpl(BloodBankRepo bloodBankRepo) {
		this.bloodBankRepo = bloodBankRepo;
	}

	@Override
	public List<BloodBank> getAllBloodBank() {
		return bloodBankRepo.findAll();
	}

	@Override
	public BloodBank getBloodBankById(Long id) {
		return bloodBankRepo.findById(id).orElse(null);
	}

	@Override
	public BloodBank addBloodBank(BloodBank bloodBank) {
		
		 return bloodBankRepo.save(bloodBank);
	}

	@Override
	@Transactional
	public BloodBank updateBloodBank(Long id, BloodBank bloodBank) {
		BloodBank existingBloodBank = bloodBankRepo.findById(id).orElse(null);
	        if (existingBloodBank != null) {
	        	existingBloodBank.setAddress(bloodBank.getAddress());
	        	existingBloodBank.setBloodbankName(bloodBank.getBloodbankName());
	        	existingBloodBank.setCity(bloodBank.getCity());
	        	existingBloodBank.setEmail(bloodBank.getEmail());
	        	existingBloodBank.setPhone(bloodBank.getPhone());
	        	existingBloodBank.setWebsite(bloodBank.getWebsite());
	            return bloodBankRepo.save(existingBloodBank);
	        }
	        return null;
	}


	@Override
	public void deleteBloodBank(Long id) {
		bloodBankRepo.deleteById(id);
		
	}

	
}
