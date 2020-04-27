package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.ormlearn.model.Stock;

public interface StockRepository extends JpaRepository<Stock,Integer> {
	
	@Query(value="select * from stock where st_code='fb' AND st_date between '2019-09-01' and '2019-09-30'",nativeQuery=true)
	List<Stock> findByDate();
	
	@Query(value="select * from stock where st_code='GOOGL' and st_close>1250",nativeQuery=true)
	List<Stock> findByPrice();
	
	List<Stock> findTop3DateByOrderByVolumeDesc();
	
	List<Stock> findTop3DateByCodeOrderByCloseAsc(String code);

}
