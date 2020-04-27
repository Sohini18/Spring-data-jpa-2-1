package com.cognizant.ormlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	@Transactional
     public List<Stock>  getByDate()
 {
	 List<Stock> result=stockRepository.findByDate();
	 return result;

	}
	

	@Transactional
     public List<Stock>  getByPrice()
 {
	 List<Stock> result=stockRepository.findByPrice();
	 return result;

	}
	@Transactional
    public List<Stock>  getByVolume()
{
	 List<Stock> result=stockRepository.findTop3DateByOrderByVolumeDesc();
	 return result;

	}
	
	@Transactional
    public List<Stock>  getByClose(String code)
{
	 List<Stock> result=stockRepository.findTop3DateByCodeOrderByCloseAsc(code);
	 return result;

	}
	
	
	
	
	
	
	
	
	
	
}
