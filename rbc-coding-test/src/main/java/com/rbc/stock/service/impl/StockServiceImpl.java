package com.rbc.stock.service.impl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rbc.stock.entity.StockEntity;
import com.rbc.stock.exception.TickerNotFoundException;
import com.rbc.stock.model.Stock;
import com.rbc.stock.repository.StockRepository;
import com.rbc.stock.service.StockService;


@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Value("${batch_size}")
	private int batchSize;
	
	private static Logger logger = Logger.getLogger(StockServiceImpl.class.getName());

	
	@Override
	public Stock addStock(Stock stock) {
		StockEntity entity= repo.save(this.mapper.map(stock, StockEntity.class));
		return this.mapper.map(entity, Stock.class);
	}


	@Override
	public List<Stock> getListByTicker(String stock) {
		List<StockEntity> list = repo.findByTicker(stock);
		if(list.isEmpty()) {
			throw new TickerNotFoundException("Ticker "+stock +"Not Found.");
		}
		Type listType = new TypeToken<List<Stock>>() {}.getType();
		return this.mapper.map(list,listType);
	}


	@Override
	public void uploadStocks(MultipartFile file) {
		try {
			List<Stock> list = readStockFromExcelFile(file);
			for(int i=0;i< list.size();i = i+ batchSize) {
				if(i+batchSize > list.size()) {
					List<Stock> l = list.subList(i, list.size());
					Type listType = new TypeToken<List<StockEntity>>() {}.getType();
					repo.saveAll(this.mapper.map(l,listType));
					break;
				}
			
				List<Stock> l = list.subList(i, i+batchSize);
				Type listType = new TypeToken<List<StockEntity>>() {}.getType();
				repo.saveAll(this.mapper.map(l,listType));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, "Exception occured while reading from file! ");
		}
	}
	
	public List<Stock> readStockFromExcelFile(MultipartFile file) throws IOException {
		List<Stock> list = new ArrayList<>();
		InputStream inputStream = new BufferedInputStream(file.getInputStream());
		 
	    Workbook workbook = new XSSFWorkbook(inputStream);
	    Sheet firstSheet = workbook.getSheetAt(0);
	    DataFormatter fmt = new DataFormatter();

	    Iterator<Row> iterator = firstSheet.iterator();
	 
	    while (iterator.hasNext()) {
	        Row nextRow = iterator.next();
	        if(nextRow.getRowNum() == 0) {
	        	continue; //Omitting the headers
	        }
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	        Stock s = new Stock();
	        
	        while(cellIterator.hasNext()) {
	        	Cell nextCell = cellIterator.next();
	            int columnIndex = nextCell.getColumnIndex();
	            String value = fmt.formatCellValue(nextCell);

	            switch (columnIndex) {
	            case 0:
	                s.setQuarter((Integer.parseInt(value)));
	                break;
	            case 1:
	                s.setStock(value);
	                break;
	            case 2:
	            	Date d = nextCell.getDateCellValue();
	                s.setDate(new SimpleDateFormat("MM/dd/yyyy").format(d));
	                break;
	            case 3:
	            	StringBuilder sb = new StringBuilder(value);
	            	sb.deleteCharAt(0);
	                s.setOpen(new BigDecimal(sb.toString()));
	                break;
	            case 4:
	            	StringBuilder sb1 = new StringBuilder(value);
	            	sb1.deleteCharAt(0);
	                s.setHigh(new BigDecimal(sb1.toString()));
	                break;
	            case 5:
	            	StringBuilder sb2 = new StringBuilder(value);
	            	sb2.deleteCharAt(0);

	                s.setLow(new BigDecimal(sb2.toString()));
	                break;
	            case 6:
	            	StringBuilder sb3 = new StringBuilder(value);
	            	sb3.deleteCharAt(0);
	            	
	                s.setClose(new BigDecimal(sb3.toString()));
	                break;
	            case 7:
	                s.setVolume((Long.parseLong(value)));
	                break;
	            case 8:
	                s.setPercentageChangePrice((Double.parseDouble(value)));
	                break;
	            case 9:
	                s.setPercentageChangeOverLastWk((Double.parseDouble(value)));
	                break;
	            case 10:
	                s.setPrevWkVolume((Long.parseLong(value)));
	                break;
	            case 11 : 
	            	StringBuilder sb4 = new StringBuilder(value);
	            	sb4.deleteCharAt(0);
	            	
	            	s.setNextWkOpen(new BigDecimal(sb4.toString()));
	            	break;
	            case 12:
	            	StringBuilder sb5 = new StringBuilder(value);
	            	sb5.deleteCharAt(0);
	            	
	            	s.setNextWkClose(new BigDecimal(sb5.toString()));
	            	break;
	            case 13 :
	            	s.setPercentageChangeNextWkPrice((Double.parseDouble(value)));
	            	break;
	            case 14:
	            	s.setDaysToNextDivident((Integer.parseInt(value)));
	            	break;
	            case 15:
	            	s.setPercentageReturnNextDivident((Double.parseDouble(value)));
	            	break;
	            default: break;
	            }
	        }
	        list.add(s);
	    }
	    workbook.close();
	    inputStream.close();
	    return list;
	}

}
