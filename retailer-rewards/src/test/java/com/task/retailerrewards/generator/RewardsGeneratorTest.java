package com.task.retailerrewards.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.task.retailerrewards.util.RewardCalculator;

@SpringBootTest
class RewardsGeneratorTest {

	@Autowired
	RewardCalculator rewardCalculator;
	
	@Test
	void findRewardsTest() {
		// Below 50
		assertEquals(0, rewardCalculator.findRewards(10L));
		// Above 50 abd Below 100
		assertEquals(40, rewardCalculator.findRewards(90L));
		// Above 100
		assertEquals(90, rewardCalculator.findRewards(120L));
	}
}