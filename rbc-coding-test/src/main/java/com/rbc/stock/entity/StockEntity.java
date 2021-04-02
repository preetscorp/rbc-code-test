package com.rbc.stock.entity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class StockEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	Integer quarter;
	@Column
	String stock;
	@Column
	Date date;
	@Column
	BigDecimal open;
	@Column
	BigDecimal high;
	@Column
	BigDecimal low;
	@Column
	BigDecimal close;
	@Column
	Long volume;
	@Column(name = "percentage_change_price")
	double percentageChangePrice;
	@Column(name = "percent_change_volume_over_last_wk")
	double percentageChangeOverLastWk;
	@Column(name = "previous_weeks_volume")
	Long prevWkVolume;
	@Column(name = "next_weeks_open")
	BigDecimal nextWkOpen;
	@Column(name = "next_weeks_close")
	BigDecimal nextWkClose;
	@Column(name = "percent_change_next_weeks_price")
	double percentageChangeNextWkPrice;
	@Column(name = "days_to_next_dividend")
    int daysToNextDivident;
	@Column(name = "percent_return_next_dividend")
    double percentageReturnNextDivident;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public Date getDate() {
		return date;
	}
	public void setDate(String date) {
		Date d = null;
	    try {
	      SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	      d = format.parse(date);
	    } catch(ParseException e) {
	      e.printStackTrace();
	    }
		this.date = d;
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
	public void setDate(Date date) {
		this.date = date;
	}
	
}
