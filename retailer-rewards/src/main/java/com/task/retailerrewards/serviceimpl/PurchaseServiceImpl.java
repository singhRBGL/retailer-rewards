package com.task.retailerrewards.serviceimpl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.retailerrewards.model.Purchase;
import com.task.retailerrewards.repository.PurchaseRepository;
import com.task.retailerrewards.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository repository;

	@Override
	public Purchase findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Purchase> findAll() {
		return (List<Purchase>) repository.findAll();
	}

	@Override
	public List<Purchase> findByPurchaseDate(Date startDate, Date endDate) {
		return (List<Purchase>) repository.findByPurchaseDate(startDate, endDate);
	}


}
