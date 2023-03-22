package com.task.retailerrewards.service;

import java.util.List;

import com.task.retailerrewards.dto.RewardsSummary;

public interface RewardsMonthlyForQuaterService {
	List<RewardsSummary> findMonthlyForQuaterSummary();
}
