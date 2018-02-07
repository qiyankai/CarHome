package com.carba.manage.mapper;

import com.carba.manage.pojo.UsCar2016;
import org.apache.ibatis.annotations.Insert;

public interface SelCar2017Mapper {

    @Insert("INSERT INTO us_brand_2016 VALUES (null,#{carType},#{sel2016},#{sel2015},#{zhangfu})")
    void saveSelCar2017(UsCar2016 usCar2016);
}
