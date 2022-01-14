package com.saicharan.Inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saicharan.Inventory.models.Supplier;
import com.saicharan.Inventory.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	public void createSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	public List<Supplier> getSuppliers() {
		return supplierRepository.findAll();
	}

	public Optional<Supplier> getSupplierById(String emailId) {
		return supplierRepository.findById(emailId);
	}
}
