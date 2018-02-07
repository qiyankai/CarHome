package com.carba.manage.mapper;


import com.carba.manage.pojo.Series;
import com.carba.common.mapper.SysMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesMapper extends SysMapper<Series> {
    void saveSeries(Series series);
}
