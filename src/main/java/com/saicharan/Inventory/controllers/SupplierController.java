package com.saicharan.Inventory.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saicharan.Inventory.models.Supplier;
import com.saicharan.Inventory.services.SupplierService;

@RestController
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	
	@RequestMapping(value = "/supplier/create", method = RequestMethod.POST)
	public void createSupplier(@RequestBody Supplier supplier) {
		supplierService.createSupplier(supplier);
	}
	
	@RequestMapping(value = "/suppliers")
	public List<Supplier> getSuppliers(){
		return supplierService.getSuppliers();
	}
	
	@RequestMapping(value = "/supplier/{emailId}")
	public Optional<Supplier> getSupplier(@PathVariable(value = "emailId") String emailId) {
		return supplierService.getSupplierById(emailId);
	}
	

}