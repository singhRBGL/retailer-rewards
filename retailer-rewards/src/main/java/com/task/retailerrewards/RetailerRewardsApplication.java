package com.task.retailerrewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.task.retailerrewards.config.RewardConfig;

@SpringBootApplication
@EnableConfigurationProperties(RewardConfig.class)
//@EnableCircuitBreaker
public class RetailerRewardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailerRewardsApplication.class, args);
	}

}
