package com.task.retailerrewards.util;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.task.retailerrewards.config.RewardConfig;

@Component
public class RewardCalculator {

	private static Logger logger = LoggerFactory.getLogger(RewardCalculator.class);

	@Autowired
	private RewardConfig rewardConfig;

	public Long findRewards(Long price) {
		int defaultPoint = rewardConfig.getPoint().getDefaultPoint();

		int firstLimitPoint = rewardConfig.getPoint().getFirstLimit();
		int firstLowerLimit = rewardConfig.getPrice().getFirstLowerLimit();
		int firstUpperLimit = rewardConfig.getPrice().getFirstUpperLimit();

		int secondLimitPoint = rewardConfig.getPoint().getSecondLimit();
		int secondLowerLimit = rewardConfig.getPrice().getSecondLowerLimit();

		long aboveFiftyReward = price > firstLowerLimit
				? (price < firstUpperLimit ? (price - firstLowerLimit) * firstLimitPoint
						: (firstUpperLimit - firstLowerLimit) * firstLimitPoint)
				: defaultPoint;

		long aboveHundredReward = price > secondLowerLimit ? (price - secondLowerLimit) * secondLimitPoint
				: defaultPoint;

		logger.debug("price : " + price + " , aboveFiftyReward : " + aboveFiftyReward + " , aboveHundredReward : "
				+ aboveHundredReward);

		return aboveFiftyReward + aboveHundredReward;
	}

	public int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		logger.debug("get month for the date : " + date);
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

}
