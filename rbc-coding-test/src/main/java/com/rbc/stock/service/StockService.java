package com.rbc.stock.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rbc.stock.model.Stock;

public interface StockService {

	Stock addStock(Stock stock);
	
	List<Stock> getListByTicker(String ticker);
	
	void uploadStocks(MultipartFile file);
}
