package com.rbc.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rbc.stock.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer> {

	@Query("SELECT s from StockEntity s where s.stock=:stock")
	List<StockEntity> findByTicker(String stock);
	
}
