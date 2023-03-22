package com.task.retailerrewards.service;

import java.sql.Date;
import java.util.List;

import com.task.retailerrewards.model.Purchase;

public interface PurchaseService {

	Purchase findById(Long id);

	List<Purchase> findAll();
	
	List<Purchase> findByPurchaseDate(Date startDate, Date endDate);
}
