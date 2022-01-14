package com.saicharan.Inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saicharan.Inventory.models.Distributor;
import com.saicharan.Inventory.repository.DistributorRepository;

@Service
public class DistributorService {
	
	@Autowired
	private DistributorRepository distributorRepository;
	
	public void createDistributor(Distributor distributor) {
		distributorRepository.save(distributor);
	}

	public List<Distributor> getDistributors() {
		return distributorRepository.findAll();
	}

	public Optional<Distributor> getDistributorById(String emailId) {
		return distributorRepository.findById(emailId);
	}
}
