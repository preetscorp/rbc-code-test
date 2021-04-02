package com.rbc.stock.model;

import java.math.BigDecimal;

public class Stock {

	Integer id;
	Integer quarter;
	String stock;
	String date;
	BigDecimal open;
	BigDecimal high;
	BigDecimal low;
	BigDecimal close;
	Long volume;
	double percentageChangePrice;
	double percentageChangeOverLastWk;
	Long prevWkVolume;
	BigDecimal nextWkOpen;
	BigDecimal nextWkClose;
	double percentageChangeNextWkPrice;
    int daysToNextDivident;
    double percentageReturnNextDivident;


	
	public Integer getQuarter() {
		return quarter;
	}
	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getOpen() {
		return open;
	}
	public void setOpen(BigDecimal open) {
		this.open = open;
	}
	public BigDecimal getHigh() {
		return high;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	public BigDecimal getLow() {
		return low;
	}
	public void setLow(BigDecimal low) {
		this.low = low;
	}
	public BigDecimal getClose() {
		return close;
	}
	public void setClose(BigDecimal close) {
		this.close = close;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public double getPercentageChangePrice() {
		return percentageChangePrice;
	}
	public void setPercentageChangePrice(double percentageChangePrice) {
		this.percentageChangePrice = percentageChangePrice;
	}
	public double getPercentageChangeOverLastWk() {
		return percentageChangeOverLastWk;
	}
	public void setPercentageChangeOverLastWk(double percentageChangeOverLastWk) {
		this.percentageChangeOverLastWk = percentageChangeOverLastWk;
	}
	public Long getPrevWkVolume() {
		return prevWkVolume;
	}
	public void setPrevWkVolume(Long prevWkVolume) {
		this.prevWkVolume = prevWkVolume;
	}
	public BigDecimal getNextWkOpen() {
		return nextWkOpen;
	}
	public void setNextWkOpen(BigDecimal nextWkOpen) {
		this.nextWkOpen = nextWkOpen;
	}
	public BigDecimal getNextWkClose() {
		return nextWkClose;
	}
	public void setNextWkClose(BigDecimal nextWkClose) {
		this.nextWkClose = nextWkClose;
	}
	public double getPercentageChangeNextWkPrice() {
		return percentageChangeNextWkPrice;
	}
	public void setPercentageChangeNextWkPrice(double percentageChangeNextWkPrice) {
		this.percentageChangeNextWkPrice = percentageChangeNextWkPrice;
	}
	public int getDaysToNextDivident() {
		return daysToNextDivident;
	}
	public void setDaysToNextDivident(int daysToNextDivident) {
		this.daysToNextDivident = daysToNextDivident;
	}
	public double getPercentageReturnNextDivident() {
		return percentageReturnNextDivident;
	}
	public void setPercentageReturnNextDivident(double percentageReturnNextDivident) {
		this.percentageReturnNextDivident = percentageReturnNextDivident;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
