package com.carba.manage.mapper;


import com.carba.common.mapper.SysMapper;
import com.carba.manage.pojo.Car2016;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface Car2016Mapper extends SysMapper<Car2016> {

    @Insert("insert into cartest values(null,#{carName},#{carNum})")
    void saveCar2016(Car2016 car2016);

    @Select("select car_name from car2017 ")
    List<String> selectCarName();

    @Select("select car_num from car2017 ")
    List<String> selectCarNum();

    @Select("select car_name from car2016 ")
    List<String> selectCarName2016();

    @Select("select car_num from car2016 ")
    List<String> selectCarNum2016();


    @Select("select car_name from suv2016 ")
    List<String> selectSuvName2016();

    @Select("select car_num from suv2016 ")
    List<String> selectSuvNum2016();


    @Select("select car_name from suv2017 ")
    List<String> selectSuvName2017();

    @Select("select car_num from suv2017 ")
    List<String> selectSuvNum2017();




}
