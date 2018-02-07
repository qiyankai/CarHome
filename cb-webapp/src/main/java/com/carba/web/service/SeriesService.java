package com.carba.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carba.web.mapper.SeriesMapper;
import com.carba.web.pojo.Series;

@Service
public class SeriesService {

	@Autowired
	private  SeriesMapper seriesMapper;

	public  Series findseriesById(int seriesId) {

		return seriesMapper.findseriesById(seriesId);
	}
	
	

	
}
