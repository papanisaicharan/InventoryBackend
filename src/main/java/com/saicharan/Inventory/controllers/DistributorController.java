package com.saicharan.Inventory.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saicharan.Inventory.models.Distributor;
import com.saicharan.Inventory.services.DistributorService;

@RestController
public class DistributorController {

	@Autowired
	private DistributorService distributorService;
	
	@RequestMapping(value = "/distributor/create", method = RequestMethod.POST)
	public void createDistributor(@RequestBody Distributor distributor) {
		distributorService.createDistributor(distributor);
	}
	
	@RequestMapping(value = "/distributors")
	public List<Distributor> getDistributors(){
		return distributorService.getDistributors();
	}
	
	@RequestMapping(value = "/distributor/{emailId}")
	public Optional<Distributor> getDistributor(@PathVariable(value = "emailId") String emailId) {
		return distributorService.getDistributorById(emailId);
	}

}
