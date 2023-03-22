package com.task.retailerrewards.serviceimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.retailerrewards.dto.RewardsSummary;
import com.task.retailerrewards.model.Purchase;
import com.task.retailerrewards.service.PurchaseService;
import com.task.retailerrewards.service.RewardsMonthlyForQuaterService;
import com.task.retailerrewards.service.RewardsQuaterlyService;
import com.task.retailerrewards.util.RewardCalculator;

@Service
public class RewardsServiceImpl implements RewardsMonthlyForQuaterService, RewardsQuaterlyService {

	private static Logger logger = LoggerFactory.getLogger(RewardsServiceImpl.class);

	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	RewardCalculator rewardCalculator;

	/**
	 * Returns rewards for each customer per month for a quater
	 * 
	 * @return List of Reward Summary for each customer
	 */
	@Override
//	@HystrixCommand(fallbackMethod = "defaultFallback")
	public List<RewardsSummary> findMonthlyForQuaterSummary() {

		logger.debug("Inside findMonthlySummary");

		List<Purchase> transactions = getLastThreeMonthsPurchases();
		
		Map<String, Map<Integer, RewardsSummary>> totalSummary = new HashMap<>();

		for (Purchase transaction : transactions) {

			String customerName = transaction.getCustomerName();
			Map<Integer, RewardsSummary> monthlySummary = totalSummary.getOrDefault(customerName, new HashMap<>());

			int month = rewardCalculator.getMonth(transaction.getPurchaseDate());
			RewardsSummary summary = monthlySummary.getOrDefault(month, new RewardsSummary(month, customerName, 0));

			summary.setCumulativeRewards(
					summary.getCumulativeRewards() + rewardCalculator.findRewards(transaction.getPrice()));
			monthlySummary.put(month, summary);
			totalSummary.put(customerName, monthlySummary);
		}

		List<RewardsSummary> summaryList = new ArrayList<>();
		for (Map.Entry<String, Map<Integer, RewardsSummary>> entry : totalSummary.entrySet()) {
			summaryList.addAll(entry.getValue().values());
		}

		return summaryList;
	}

	private List<Purchase> getLastThreeMonthsPurchases() {
		Date todayDate = new Date(System.currentTimeMillis());

		Calendar c= Calendar.getInstance();
		c.add(Calendar.MONTH, -3);
		java.util.Date utilDate=c.getTime();
		Date threeMonthOldDate = new Date(utilDate.getTime());
		
		logger.info("threeMonthOldDate : " + threeMonthOldDate + " , todayDate : " + todayDate);
		List<Purchase> transactions = purchaseService.findByPurchaseDate(threeMonthOldDate, todayDate); //findAll();
		return transactions;
	}

	/**
	 * Returns total rewards for each customer for a quater
	 * 
	 * @return List of Total Reward Summary for each customer
	 */
	@Override
//	@HystrixCommand(fallbackMethod = "defaultFallback")
	public List<RewardsSummary> findQuaterlyTotalSummary() {
		List<Purchase> transactions = getLastThreeMonthsPurchases(); //purchaseService.findAll();

		Map<String, RewardsSummary> totalSummary = new HashMap<>();

		for (Purchase transaction : transactions) {
			String customerName = transaction.getCustomerName();
			RewardsSummary summary = totalSummary.getOrDefault(customerName, new RewardsSummary(null, customerName, 0));
			summary.setCumulativeRewards(
					summary.getCumulativeRewards() + rewardCalculator.findRewards(transaction.getPrice()));
			totalSummary.put(customerName, summary);
		}

		return new ArrayList<>(totalSummary.values());
	}
	
    private List<RewardsSummary> defaultFallback() {
    	logger.warn("Rewars Service has problem, please check");
        return new ArrayList<RewardsSummary>();
    }
}
