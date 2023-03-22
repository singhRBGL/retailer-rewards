package com.task.retailerrewards.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.retailerrewards.dto.RewardsSummary;
import com.task.retailerrewards.service.RewardsMonthlyForQuaterService;
import com.task.retailerrewards.service.RewardsQuaterlyService;

@RestController
@RequestMapping("/rewards")
public class RewardController {

	@Autowired
	private RewardsMonthlyForQuaterService rewardsMonthlyForQuaterService;

	@Autowired
	private RewardsQuaterlyService rewardsQuaterlyService;

//	private static Logger logger = LoggerFactory.getLogger(RewardController.class);

	@RequestMapping(value = "/monthly-for-quater", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RewardsSummary> findMonthlySummary(HttpServletResponse response) throws IOException {

		List<RewardsSummary> summaryList = rewardsMonthlyForQuaterService.findMonthlyForQuaterSummary();

//		if(true)
//		throw new RuntimeException("RKS Exception");

		return summaryList;
	}

	// @RespondBody is written explicitly to denote that if not written then
	// @RestController takes care of it.
	@RequestMapping(value = "/quatrely", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<RewardsSummary> findTotalSummary(HttpServletResponse response) throws IOException {

		List<RewardsSummary> summaryList = rewardsQuaterlyService.findQuaterlyTotalSummary();

		return summaryList;
	}
}
