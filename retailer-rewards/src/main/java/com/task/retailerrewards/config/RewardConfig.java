package com.task.retailerrewards.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties("rewards")
public class RewardConfig {

	private Point point;
	private Price price;

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public static class Point {

		private int defaultPoint;
		private int firstLimit;
		private int secondLimit;

		public int getDefaultPoint() {
			return defaultPoint;
		}

		public void setDefaultPoint(int defaultPoint) {
			this.defaultPoint = defaultPoint;
		}

		public int getFirstLimit() {
			return firstLimit;
		}

		public void setFirstLimit(int firstLimit) {
			this.firstLimit = firstLimit;
		}

		public int getSecondLimit() {
			return secondLimit;
		}

		public void setSecondLimit(int secondLimit) {
			this.secondLimit = secondLimit;
		}

	}

	public static class Price {

		private int firstLowerLimit;
		private int firstUpperLimit;
		private int secondLowerLimit;

		public int getFirstLowerLimit() {
			return firstLowerLimit;
		}

		public void setFirstLowerLimit(int firstLowerLimit) {
			this.firstLowerLimit = firstLowerLimit;
		}

		public int getFirstUpperLimit() {
			return firstUpperLimit;
		}

		public void setFirstUpperLimit(int firstUpperLimit) {
			this.firstUpperLimit = firstUpperLimit;
		}

		public int getSecondLowerLimit() {
			return secondLowerLimit;
		}

		public void setSecondLowerLimit(int secondLowerLimit) {
			this.secondLowerLimit = secondLowerLimit;
		}

	}

}
