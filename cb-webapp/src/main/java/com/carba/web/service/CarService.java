package com.carba.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carba.web.mapper.CarMapper;
import com.carba.web.pojo.Car;

@Service
public class CarService {

	@Autowired
	private CarMapper carMapper;

	public List<Car> findcarsBySId(int seriesId) {
		
		return carMapper.findcarsBySId(seriesId);
	}

	public List<Car> findcarsByCId(int carId) {
		
		return carMapper.findcarsByCId(carId);
	}

	public String findString(int carId) {
		
			String jiasu = carMapper.findString01(carId);
			String shache = carMapper.findString02(carId);
			String youhao = carMapper.findString03(carId);
			
			
		
		return jiasu+","+shache+","+youhao;

	}
	
}
