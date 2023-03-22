package com.task.retailerrewards.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RewardsSummary {

	private Integer month;
	private String customer;
	private long cumulativeRewards;

	public RewardsSummary(Integer month, String customer, long cumulativeRewards) {
		super();
		this.month = month;
		this.customer = customer;
		this.cumulativeRewards = cumulativeRewards;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public long getCumulativeRewards() {
		return cumulativeRewards;
	}

	public void setCumulativeRewards(long cumulativeRewards) {
		this.cumulativeRewards = cumulativeRewards;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
