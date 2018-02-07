package com.carba.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.carba.web.pojo.Car;

public interface CarMapper {

	public List<Car> findcarsBySId(int seriesId);

	public List<Car> findcarsByCId(int carId);

	@Select("select jiasu from carinfo where carId=#{carId}")
	public String findString01(int carId);
	@Select("select shache from carinfo where carId=#{carId}")
	public String findString02(int carId);
	@Select("select haoyou from carinfo where carId=#{carId}")
	public String findString03(int carId);
	

}
