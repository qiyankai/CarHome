package com.carba.manage.service;

import com.carba.manage.mapper.Car2016Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EchartsService {

    @Autowired
    private Car2016Mapper car2016Mapper;


    public List<String> selectCarName(){
        return car2016Mapper.selectCarName();
    }

    public List<String> selectCarName2016(){
        return car2016Mapper.selectCarName2016();
    }

    public List<String> selectCarNum2016(){
        return car2016Mapper.selectCarNum2016();
    }

    public List<Integer> selectCarNum() {
        List<String> list = car2016Mapper.selectCarNum();
        List<Integer> temp = new ArrayList<Integer>();
        for (String s : list) {
            temp.add(new Integer(s));
        }
        return temp;
    }

    public List<String> selectSuvName2017() {
        return car2016Mapper.selectSuvName2017();
    }

    public List<String> selectSuvNum2017() {
        return car2016Mapper.selectSuvNum2017();
    }

    public List<String> selectSuvName2016() {
        return car2016Mapper.selectSuvName2016();
    }

    public List<String> selectSuvNum2016() {
        return car2016Mapper.selectSuvNum2016();
    }
}