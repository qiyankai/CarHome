package com.carba.manage.mapper;


import com.carba.manage.pojo.Car;
import com.carba.common.mapper.SysMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface CarMapper extends SysMapper<Car> {
    void saveCar(Car car);
}
