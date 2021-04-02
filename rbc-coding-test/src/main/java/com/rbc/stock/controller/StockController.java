package com.rbc.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rbc.stock.model.Stock;
import com.rbc.stock.model.UploadResponse;
import com.rbc.stock.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	StockService service;

	@GetMapping("{stock}")
	public List<Stock> getDetailsByTicker(@PathVariable("stock") String stock) {
		return this.service.getListByTicker(stock);
	}
	
	@PostMapping("/add")
	public Stock createNewStock(@RequestBody Stock stock) {
		return service.addStock(stock);
	}
	
    @PostMapping("/uploadFile")
	public UploadResponse uploadData( @RequestParam("file") MultipartFile file){
    	this.service.uploadStocks(file);
		return new UploadResponse(file.getOriginalFilename(), HttpStatus.OK, null);
	}
}
