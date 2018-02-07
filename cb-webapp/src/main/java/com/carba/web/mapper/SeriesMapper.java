package com.carba.web.mapper;

import com.carba.web.pojo.Series;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesMapper {
	 Series findseriesById(int seriesId) ;
}
