package com.anuj.asn3.services;

import java.util.List;

import com.anuj.asn3.model.BloodBank;
import com.anuj.asn3.model.BloodStock;

public interface BloodBankServices {

	List<BloodBank> getAllBloodBank();

	BloodBank getBloodBankById(Long id);

	BloodBank addBloodBank(BloodBank bloodBank);

	BloodBank updateBloodBank(Long id, BloodBank bloodBank);

	void deleteBloodBank(Long id);

}
